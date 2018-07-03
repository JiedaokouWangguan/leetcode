public class Question570{
    /*
    select b.Name
    from
    (
    select ManagerId
    from Employee
    group by ManagerId
    having(count(1) >= 5)
    )a
    join
    (
    select * from Employee
    )b
    on a.ManagerId = b.Id
    */

}
