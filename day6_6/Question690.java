import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Employee{
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class Question690{
    public int getImportance(List<Employee> employees, int id){
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        return dfs(map, id, new boolean[2000]);
    }

    private int dfs(HashMap<Integer, Employee> employees, int id, boolean[] visited){
        if(visited[id])    
            return 0;
        visited[id] = true;
        int tmpResult = 0;
        for(int i = 0;i<employees.get(id).subordinates.size();i++){
            tmpResult += dfs(employees, employees.get(id).subordinates.get(i), visited);
        }
        return tmpResult + employees.get(id).importance;
    }
}
