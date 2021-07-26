SELECT E1.employee_id, R1.team_size
FROM Employee AS E1
INNER JOIN(SELECT E2.team_id, COUNT(*) AS 'team_size'
            FROM Employee AS E2
            GROUP BY E2.team_id) AS R1) ON E1.team_id = R1.team_id;

-- Write an SQL query to find the team size of each of the employees.
--
-- Return result table in any order.
--
-- The query result format is in the following example:
--
-- Employee Table:
-- +-------------+------------+
-- | employee_id | team_id    |
-- +-------------+------------+
-- |     1       |     8      |
-- |     2       |     8      |
-- |     3       |     8      |
-- |     4       |     7      |
-- |     5       |     9      |
-- |     6       |     9      |
-- +-------------+------------+
-- Result table:
-- +-------------+------------+
-- | employee_id | team_size  |
-- +-------------+------------+
-- |     1       |     3      |
-- |     2       |     3      |
-- |     3       |     3      |
-- |     4       |     1      |
-- |     5       |     2      |
-- |     6       |     2      |
-- +-------------+------------+
-- Employees with Id 1,2,3 are part of a team with team_id = 8.
-- Employees with Id 4 is part of a team with team_id = 7.
-- Employees with Id 5,6 are part of a team with team_id = 9.