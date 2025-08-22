SELECT name
FROM Customer
WHERE referee_id <> 2 
   OR referee_id IS NULL;


1. SELECT name

We only want the name column in the result.

2. FROM Customer

We are reading from the Customer table.

3. WHERE referee_id <> 2 OR referee_id IS NULL

This is the main filtering condition.
It has two parts joined by OR:

Condition A: referee_id <> 2

<> means "not equal to".

So this keeps customers whose referee_id is not 2 (could be 1, 3, 5, etc.).

Condition B: referee_id IS NULL

NULL means no referee (not referred by anyone).

IS NULL explicitly checks for missing values.

These customers are also included in the result.
