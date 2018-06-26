public class Question185{
    /*
       Select dep.Name as Department, emp.Name as Employee, emp.Salary from Department dep, 
       Employee emp where emp.DepartmentId=dep.Id and 
       (Select count(distinct Salary) From Employee where DepartmentId=dep.Id and Salary>emp.Salary)<3
    */
}
