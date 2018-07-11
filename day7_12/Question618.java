public class Question618{
    /*
       select america.name as America,asia.name as Asia,europe.name as Europe from
       (select @counter1:= @counter1+1 as id,name from student,(select @counter1 :=0) as temp where continent = 'America' order by name) as america left outer join
       (select @counter2:= @counter2+1 as id,name from student,(select @counter2 :=0) as temp where continent = 'Asia' order by name) as asia on
       america.id = asia.id
       left outer join
       (select @counter3:= @counter3+1 as id,name from student,(select @counter3 :=0) as temp where continent = 'Europe' order by name) as europe on (america.id = europe.id ))
       */
}
