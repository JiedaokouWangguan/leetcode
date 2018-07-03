public class Question603{
    /*
       select C1.seat_id from cinema C1  where 
       C1.free=1 
       and 
       (
       C1.seat_id+1 in (select seat_id from cinema where free=1) 
       or 
       C1.seat_id-1 in (select seat_id from cinema where free=1) 
       ) 
       order by C1.seat_id))
       */
}
