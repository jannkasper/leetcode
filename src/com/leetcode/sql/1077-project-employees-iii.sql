SELECT project_id, employee_id
FROM Project
INNER JOIN Employee ON Project.employee_id = Employee.employee_id
GROUP BY project_id
HAVING MAX(year);

-- Write an SQL query that reports the most experienced employees in each project.
-- In case of a tie, report all employees with the maximum number of experience years.
--
-- The query result format is in the following example:
--
-- Project table:
-- +-------------+-------------+
-- | project_id  | employee_id |
-- +-------------+-------------+
-- | 1           | 1           |
-- | 1           | 2           |
-- | 1           | 3           |
-- | 2           | 1           |
-- | 2           | 4           |
-- +-------------+-------------+
--
-- Employee table:
-- +-------------+--------+------------------+
-- | employee_id | name   | experience_years |
-- +-------------+--------+------------------+
-- | 1           | Khaled | 3                |
-- | 2           | Ali    | 2                |
-- | 3           | John   | 3                |
-- | 4           | Doe    | 2                |
-- +-------------+--------+------------------+
--
-- Result table:
-- +-------------+---------------+
-- | project_id  | employee_id   |
-- +-------------+---------------+
-- | 1           | 1             |
-- | 1           | 3             |
-- | 2           | 1             |
-- +-------------+---------------+
-- Both employees with id 1 and 3 have the most experience among the employees of the first project.
-- For the second project, the employee with id 1 has the most experience.
