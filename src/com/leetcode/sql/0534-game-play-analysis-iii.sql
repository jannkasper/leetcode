SELECT subQuery.player_id, subQuery.event_date, subQuery.games_played_so_far
FROM (
    SELECT player_id, event_date, (
        CASE
            WHEN player_id = @prevId THEN games_played + @prevScore
            ELSE games_played
        END
    ) AS 'games_played_so_far',
    @prevScore:= IF(player_id = @prevId, games_played + @prevScore, games_played),
    @prevId:=player_id
    FROM Activity, (SELECT @prevId:=-1, @prevScore:=0) var
    ORDER BY player_id, event_date ASC) as subQuery;


-- Write an SQL query that reports for each player and date, how many games played so far by the player.
-- That is, the total number of games played by the player until that date. Check the example for clarity.
--
-- The query result format is in the following example:
--
-- Activity table:
-- +-----------+-----------+------------+--------------+
-- | player_id | device_id | event_date | games_played |
-- +-----------+-----------+------------+--------------+
-- | 1         | 2         | 2016-03-01 | 5            |
-- | 1         | 2         | 2016-05-02 | 6            |
-- | 1         | 3         | 2017-06-25 | 1            |
-- | 3         | 1         | 2016-03-02 | 0            |
-- | 3         | 4         | 2018-07-03 | 5            |
-- +-----------+-----------+------------+--------------+
--
-- Result table:
-- +-----------+------------+---------------------+
-- | player_id | event_date | games_played_so_far |
-- +-----------+------------+---------------------+
-- | 1         | 2016-03-01 | 5                   |
-- | 1         | 2016-05-02 | 11                  |
-- | 1         | 2017-06-25 | 12                  |
-- | 3         | 2016-03-02 | 0                   |
-- | 3         | 2018-07-03 | 5                   |
-- +-----------+------------+---------------------+
-- For the player with id 1, 5 + 6 = 11 games played by 2016-05-02, and 5 + 6 + 1 = 12 games played by 2017-06-25.
-- For the player with id 3, 0 + 5 = 5 games played by 2018-07-03.
-- Note that for each player we only care about the days when the player logged in.