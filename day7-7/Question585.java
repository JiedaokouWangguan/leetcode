public class Question585{
    /*
        select sum(TIV_2016) as TIV_2016
        from insurance as i,
        (
        select TIV_2015, count(1) as c
        from insurance
        group by TIV_2015
        )b,
        (
        select LAT, LON, count(1) as c
        from insurance
        group by LAT, LON
        )a
        where i.TIV_2015 = b.TIV_2015 and b.c > 1 and i.LAT = a.LAT and i.LON = a.LON and a.c = 1

*/

}
