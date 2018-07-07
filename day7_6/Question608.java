public class Question608{
    /*
        select 
            t.id,
            case Type
                when t.p_id is null then "Root"
                when t.id not in p then "Leaf"
                else "Inner"
            end
        from tree as t, (select distinct p_id from tree) as p
    */
}
