public class Question571{
    /*
       select  avg(n.Number) median
       from Numbers n
       where n.Frequency >= abs((select sum(Frequency) from Numbers where Number<=n.Number) -
       (select sum(Frequency) from Numbers where Number>=n.Number))

       select avg(number) as median 
       from (
       select l.number
       from numbers l join numbers r
       group by 1
       having abs(sum(sign(l.number - r.number) * r.frequency)) <= max(l.frequency)
       ) t)

*/
}
