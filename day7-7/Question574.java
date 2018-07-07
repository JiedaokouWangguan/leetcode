public class Question574{
    /*
    select Name from
    Candidate c
    left join
    (
       select CandidateId as cd
       from Vote
       group by CandidateId
       order by count(1) desc
       limit 1
    )a
    on c.id = a.cd
    where cd is not null
    */
}
