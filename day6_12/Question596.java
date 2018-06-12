public class Question596{
    /*
    select class from(
        select class, count(*) as c
        from courses
        group by class
    )
    where c >= 5


    select distinct class
    from courses
    group by class
    having count(distinct student) >=5

    */
}
