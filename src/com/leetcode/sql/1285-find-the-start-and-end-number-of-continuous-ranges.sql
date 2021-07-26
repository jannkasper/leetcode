SELECT MIN(logs_id) as 'start_id', MAX(logs_id) as 'end_id'
FROM (SELECT logs_id, @rank :=
                CASE
                    WHEN @prev = logs_id - 1 THEN @rank
                    ELSE @rank + 1
                END AS 'rank',
                @prev := logs_id AS 'prev'
        FROM logs AS A, (SELECT @rank := 0, @prev := -1) AS B) AS C
GROUP BY C.rank
ORDER BY start_id;

-- Since some IDs have been removed from Logs. Write an SQL query to find the start
-- and end number of continuous ranges in table Logs.
--
-- Order the result table by start_id.
--
-- The query result format is in the following example:
--
-- Logs table:
-- +------------+
-- | log_id     |
-- +------------+
-- | 1          |
-- | 2          |
-- | 3          |
-- | 7          |
-- | 8          |
-- | 10         |
-- +------------+
--
-- Result table:
-- +------------+--------------+
-- | start_id   | end_id       |
-- +------------+--------------+
-- | 1          | 3            |
-- | 7          | 8            |
-- | 10         | 10           |
-- +------------+--------------+
-- The result table should contain all ranges in table Logs.
-- From 1 to 3 is contained in the table.
-- From 4 to 6 is missing in the table
-- From 7 to 8 is contained in the table.
-- Number 9 is missing in the table.
-- Number 10 is contained in the table.