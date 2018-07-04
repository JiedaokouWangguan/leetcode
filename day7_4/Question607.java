public class Question607{
    /*
     select name
     from
     (
     select s.name, r.tag
     from salesperson s
     left join
     (
        select distinct sales_id, "RED" as tag
        from orders o
        left join company c
        on o.com_id = c.com_id
        where c.name = "RED"
     )r
     on s.sales_id = r.sales_id
     )f
     where f.tag is null
   */
}
