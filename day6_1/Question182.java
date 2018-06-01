public class Question182{
    /*
     * select t.e as Email from
     * (select Email as e, Count(1) as c from Person group by Email) t
     * where t.c > 1
     *
     * select Email from Person group by Email having count(Email) > 1;
     */
}
