SELECT student_id, MAX(grade), MIN(course_id)
FROM Entrollments
WHERE (student_id, grade) = (SELECT student_id, MAX(grade)
                            FROM Enrollments
                            GROUP BY student_id)
GROUP BY student_id
ORDER BY student_id ASC;

-- Write a SQL query to find the highest grade with its corresponding course for each student.
-- In case of a tie, you should find the course with the smallest course_id.
-- The output must be sorted by increasing student_id.
--
-- The query result format is in the following example:
--
-- Enrollments table:
-- +------------+-------------------+
-- | student_id | course_id | grade |
-- +------------+-----------+-------+
-- | 2          | 2         | 95    |
-- | 2          | 3         | 95    |
-- | 1          | 1         | 90    |
-- | 1          | 2         | 99    |
-- | 3          | 1         | 80    |
-- | 3          | 2         | 75    |
-- | 3          | 3         | 82    |
-- +------------+-----------+-------+
--
-- Result table:
-- +------------+-------------------+
-- | student_id | course_id | grade |
-- +------------+-----------+-------+
-- | 1          | 2         | 99    |
-- | 2          | 2         | 95    |
-- | 3          | 3         | 82    |
-- +------------+-----------+-------+

