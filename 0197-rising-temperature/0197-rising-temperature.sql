# Write your MySQL query statement below

-- SELECT *
SELECT wl.id
FROM Weather wl
LEFT JOIN Weather wr
ON DATEDIFF(wl.recordDate, wr.recordDate) = 1
WHERE wl.temperature > wr.temperature
