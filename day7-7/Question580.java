public class Question580{
    /*
       select dept_name,
       if(student_number is null, 0, student_number) as student_number
       from department as d
       left join
       (
       select dept_id, count(1) as student_number
       from student
       group by dept_id
       )a
       on d.dept_id=a.dept_id
       order by a.student_number desc, dept_name
       */
}
