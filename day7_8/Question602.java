public class Question602{
    /*
       select id, sum(c) as num
       from       
       (          
       (      
       select requester_id as id, count(1) as c
       from request_accepted
       group by requester_id
       )      
       union all
       (      
       select accepter_id as id, count(1) as c
       from request_accepted
       group by accepter_id
       )      
       )u         
       group by id                                                                 
       order by sum(c) desc
       limit 1))
    此题有两点，union all 和 order by sum()
    */
}
