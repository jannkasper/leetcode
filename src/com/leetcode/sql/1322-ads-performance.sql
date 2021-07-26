SELECT ad_id,
        CASE
            WHEN  R1.clicked + R2.viewed = 0 THEN 0
            ELSE ROUND(100 * R1.clicked / (R1.clicked + R2.viewed), 2)
        END AS 'ctr'
FROM (SELECT ad_id, COUNT(*) AS 'clicked'
    FROM Ads
    WHERE action = 'Clicked'
    GROUP BY ad_id) AS R1
INNER JOIN (SELECT ad_id, COUNT(*) AS 'viewed'
            FROM Ads
            WHERE action = 'Viewed'
            GROUP BY ad_id) AS R2 ON R1.ad_id = R2.ad_id;


SELECT ad_id,
       CASE
           WHEN clicks + views = 0 THEN 0
           ELSE ROUND(100 * clicks / (clicks + views), 2)
       END ctr
FROM (SELECT ad_id,
            SUM(CASE
                    WHEN action ='Viewed' THEN 1
                    ELSE 0
              END) views,
            SUM(CASE
                    WHEN action = 'Clicked' THEN 1
                    ELSE 0
              END) clicks
     FROM Ads
     GROUP BY ad_id) a
ORDER BY ctr DESC,
         ad_id ASC;


-- Write an SQL query to find the ctr of each Ad.
--
-- Round ctr to 2 decimal points. Order the result table by ctr in descending order and
-- by ad_id in ascending order in case of a tie.
--
-- The query result format is in the following example:
--
-- Ads table:
-- +-------+---------+---------+
-- | ad_id | user_id | action  |
-- +-------+---------+---------+
-- | 1     | 1       | Clicked |
-- | 2     | 2       | Clicked |
-- | 3     | 3       | Viewed  |
-- | 5     | 5       | Ignored |
-- | 1     | 7       | Ignored |
-- | 2     | 7       | Viewed  |
-- | 3     | 5       | Clicked |
-- | 1     | 4       | Viewed  |
-- | 2     | 11      | Viewed  |
-- | 1     | 2       | Clicked |
-- +-------+---------+---------+
-- Result table:
-- +-------+-------+
-- | ad_id | ctr   |
-- +-------+-------+
-- | 1     | 66.67 |
-- | 3     | 50.00 |
-- | 2     | 33.33 |
-- | 5     | 0.00  |
-- +-------+-------+
-- for ad_id = 1, ctr = (2/(2+1)) * 100 = 66.67
-- for ad_id = 2, ctr = (1/(1+2)) * 100 = 33.33
-- for ad_id = 3, ctr = (1/(1+1)) * 100 = 50.00
-- for ad_id = 5, ctr = 0.00, Note that ad_id = 5 has no clicks or views.
-- Note that we don't care about Ignored Ads.
-- Result table is ordered by the ctr. in case of a tie we order them by ad_id