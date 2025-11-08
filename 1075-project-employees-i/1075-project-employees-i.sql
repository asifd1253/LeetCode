# Write your MySQL query statement below

-- | project_id | employee_id | employee_id | name   | experience_years |
-- | ---------- | ----------- | ----------- | ------ | ---------------- |
-- | 1          | 1           | 1           | Khaled | 3                |
-- | 1          | 2           | 2           | Ali    | 2                |
-- | 1          | 3           | 3           | John   | 1                |
-- | 2          | 1           | 1           | Khaled | 3                |
-- | 2          | 4           | 4           | Doe    | 2                |

SELECT p.project_id, ROUND(AVG(e.experience_years), 2) AS average_years
-- SELECT *
FROM Project p
LEFT JOIN Employee e
ON p.employee_id = e.employee_id
GROUP BY p.project_id