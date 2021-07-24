SELECT d.name as Department, sub.Name as Employee, sub.Salary
FROM (
    SELECT DepartmentId, Name, Salary, (
    CASE
        WHEN @preId = DepartmentId THEN @rank:= IF(@preSalary = Salary, @rank, @rank+1)
        ELSE @rank:=1
    END) as 'Rank',
    @preId := DepartmentId,
    @preSalary := Salary
    FROM Employee, (SELECT @rank:=0, @preSalary:=-1, @preId:=NULL) var
    ORDER BY DepartmentId, Salary DESC) as sub
JOIN Department as d ON sub.DepartmentId = d.id
WHERE sub.rank <= 3;


SELECT d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
FROM Employee e1
JOIN Department d ON e1.DepartmentId = d.Id
WHERE 3 > (SELECT COUNT(DISTINCT e2.Salary)
           FROM Employee e2
           WHERE e2.Salary > e1.Salary AND e1.DepartmentId = e2.DepartmentId);

-- The Employee table holds all employees. Every employee has an Id, and there is also a column for the department Id.
--
-- +----+-------+--------+--------------+
-- | Id | Name  | Salary | DepartmentId |
-- +----+-------+--------+--------------+
-- | 1  | Joe   | 85000  | 1            |
-- | 2  | Henry | 80000  | 2            |
-- | 3  | Sam   | 60000  | 2            |
-- | 4  | Max   | 90000  | 1            |
-- | 5  | Janet | 69000  | 1            |
-- | 6  | Randy | 85000  | 1            |
-- | 7  | Will  | 70000  | 1            |
-- +----+-------+--------+--------------+
-- The Department table holds all departments of the company.
--
-- +----+----------+
-- | Id | Name     |
-- +----+----------+
-- | 1  | IT       |
-- | 2  | Sales    |
-- +----+----------+
-- Write a SQL query to find employees who earn the top three salaries in each of the department.
-- For the above tables, your SQL query should return the following rows (order of rows does not matter).
--
-- +------------+----------+--------+
-- | Department | Employee | Salary |
-- +------------+----------+--------+
-- | IT         | Max      | 90000  |
-- | IT         | Randy    | 85000  |
-- | IT         | Joe      | 85000  |
-- | IT         | Will     | 70000  |
-- | Sales      | Henry    | 80000  |
-- | Sales      | Sam      | 60000  |
-- +------------+----------+--------+