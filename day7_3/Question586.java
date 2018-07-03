public class Question586{
    /*
    select customer_number
    from
    (
    select customer_number, count(1) as count
    from orders
    group by customer_number
    )
    order by count desc
    limit 1
    */
}
