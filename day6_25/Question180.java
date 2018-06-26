public class Question180{
    /*
    select distinct  Num as ConsecutiveNums from Logs l
    where Num = (select Num from Logs where l.Id + 1 = Id) and Num = (select Num from Logs where l.Id+2 = Id)
    */
}
