public class Question578{
    /*
       select question_id as survey_log
       from
       (
       select question_id, count(1) as c
       from survey_log
       where answer_id is not null
       group by question_id
       )a
       order by c desc
       limit 1
       */
}
