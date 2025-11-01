# Write your MySQL query statement below

SELECT el.name
FROM Employee el
INNER JOIN Employee er
ON el.id = er.managerId
GROUP BY el.name
HAVING COUNT(er.managerId) >= 5