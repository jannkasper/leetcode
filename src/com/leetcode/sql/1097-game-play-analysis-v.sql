SELECT event_date AS 'install_dt', COUNT(*) AS 'installs', (COUNT(*) / SUM(subQuery.hasRetention)) AS 'Day1_retention'
FROM (SELECT player_id, MIN(event_date), (
        CASE
            WHERE player_id ANY (SELECT FROM ACTIVITY A2
                            WHERE DATEDIFF(A1.event_date, A2.event_date) = 1
                            AND A1.player_id = A2.player_id) THEN 1
            ELSE 0
        END) AS 'hasRetention'
    FROM Activity A1
    GROUP BY player_id) AS subQuery
GROUP BY event_date
ORDER BY event_date ASC;



SELECT install_dt,Count(player_id) AS installs, Round(Count(next_day) / Count(player_id), 2) AS Day1_retention
FROM (SELECT a.player_id, a.install_dt, b.event_date AS next_day
        FROM (SELECT player_id, Min(event_date) AS install_dt
                FROM activity
                GROUP BY player_id) AS a
                LEFT JOIN activity AS b ON Datediff(b.event_date, a.install_dt) = 1 AND a.player_id = b.player_id ) AS t
GROUP  BY install_dt;

-- We define the install date of a player to be the first login day of that player.
--
-- We also define day 1 retention of some date X to be the number of players whose
-- install date is X and they logged back in on the day right after X, divided by the number of players
-- whose install date is X, rounded to 2 decimal places.
--
-- Write an SQL query that reports for each install date, the number of players that installed
-- the game on that day and the day 1 retention.
--
-- The query result format is in the following example:
--
-- Activity table:
-- +-----------+-----------+------------+--------------+
-- | player_id | device_id | event_date | games_played |
-- +-----------+-----------+------------+--------------+
-- | 1         | 2         | 2016-03-01 | 5            |
-- | 1         | 2         | 2016-03-02 | 6            |
-- | 2         | 3         | 2017-06-25 | 1            |
-- | 3         | 1         | 2016-03-01 | 0            |
-- | 3         | 4         | 2016-07-03 | 5            |
-- +-----------+-----------+------------+--------------+
--
-- Result table:
-- +------------+----------+----------------+
-- | install_dt | installs | Day1_retention |
-- +------------+----------+----------------+
-- | 2016-03-01 | 2        | 0.50           |
-- | 2017-06-25 | 1        | 0.00           |
-- +------------+----------+----------------+
-- Player 1 and 3 installed the game on 2016-03-01 but only player 1 logged back in on 2016-03-02
-- so the day 1 retention of 2016-03-01 is 1 / 2 = 0.50
-- Player 2 installed the game on 2017-06-25 but didn't log back in on 2017-06-26 so
-- the day 1 retention of 2017-06-25 is 0 / 1 = 0.00

