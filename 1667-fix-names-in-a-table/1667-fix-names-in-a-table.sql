# Write your MySQL query statement below

SELECT user_id,
       CONCAT(
        UPPER(LEFT(name, 1)),
        LOWER(RIGHT(name, LENGTH(name)-1))  //Extracts characters from the right side, Takes all characters except the first one
        ) AS name
FROM Users
ORDER BY user_id
