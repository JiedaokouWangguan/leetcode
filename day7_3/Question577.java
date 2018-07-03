public class Question577{
    /*
       select a.name, b.bonus
       from                   
       (                      
       select empId, name from Employee
       )a                     
       left join                   
       (                      
       select empId, bonus from Bonus
       )b                     
       on a.empId = b.empId
       where b.Bonus is null or b.Bonus < 1000>
       */
}
