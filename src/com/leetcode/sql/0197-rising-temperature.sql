SELECT temp.Id FROM
    (SELECT Id, recordDate, temperature, (
        CASE
            WHEN @prevDate IS NULL THEN 0
            WHEN DATEDIFF(recordDate, @prevDate) = 1 AND @prevTemp < temperature THEN 1
            ELSE 0
        END) as 'result',
        @prevDate := recordDate,
        @prevTemp := temperature
     FROM Weather, (SELECT @prevDate:= NULL, @prevTemp:=NULL) var
     ORDER BY recordDate ASC) as temp
WHERE result = 1;



SELECT w1.id as Id
FROM Weather w1,  Weather w2
WHERE DATEDIFF(w1.recordDate, w2.recordDate) = 1 AND w1.Temperature > w2.Temperature;


-- Given a Weather table, write a SQL query to find all dates' Ids
-- with higher temperature compared to its previous (yesterday's) dates.
--
-- +---------+------------------+------------------+
-- | Id(INT) | RecordDate(DATE) | Temperature(INT) |
-- +---------+------------------+------------------+
-- |       1 |       2015-01-01 |               10 |
-- |       2 |       2015-01-02 |               25 |
-- |       3 |       2015-01-03 |               20 |
-- |       4 |       2015-01-04 |               30 |
-- +---------+------------------+------------------+
-- For example, return the following Ids for the above Weather table:
--
-- +----+
-- | Id |
-- +----+
-- |  2 |
-- |  4 |
-- +----+