Select e.name
From Employee e
Where e.id In (
    Select e.managerId
    From Employee e
    Where e.managerId Is Not Null
    Group By e.managerId
    Having Count(*) >= 5
);
