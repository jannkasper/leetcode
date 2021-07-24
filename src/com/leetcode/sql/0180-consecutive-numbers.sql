SELECT DISTINCT L1.Num as ConsecutiveNums
FROM Logs as L1,Logs as L2,Logs as L3
WHERE (L1.id = L2.id + 1) AND (L2.id = L3.id + 1) AND (L1.Num = L2.Num) AND (L2.Num = L3.Num);

-- Write a SQL query to find all numbers that appear at least three times consecutively.
--
-- +----+-----+
-- | Id | Num |
-- +----+-----+
-- | 1  |  1  |
-- | 2  |  1  |
-- | 3  |  1  |
-- | 4  |  2  |
-- | 5  |  1  |
-- | 6  |  2  |
-- | 7  |  2  |
-- +----+-----+
-- For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.
--
-- +-----------------+
-- | ConsecutiveNums |
-- +-----------------+
-- | 1               |
-- +-----------------+