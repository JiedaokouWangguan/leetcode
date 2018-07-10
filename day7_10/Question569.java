public class Question569{
    /*
       SELECT
       id,
       Company,
       Salary
       FROM Employee e
       WHERE 1 >= ABS((SELECT COUNT(*) FROM Employee e1 WHERE e.company = e1.company AND e.Salary >= e1.Salary) -
       (SELECT COUNT(*) FROM Employee e2 WHERE e.company = e2.company AND e.Salary <= e2.Salary)) 
       GROUP BY Company, Salary    )
       */
}
