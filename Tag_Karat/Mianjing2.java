import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

// time complexity is O(N), O(N*N), O(N)
// space complexity is O(N*N)
// 这道题是同事的那个题，相对简单一些时间空间复杂度都是Om+n吧。
public class Mianjing2{
    
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    public HashMap<Integer, HashSet<Integer>> getFriends(Integer[][] edges){
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(Integer[] edge : edges){
            int id1 = edge[0];
            int id2 = edge[1];
            if(!map.containsKey(id1)) map.put(id1, new HashSet<Integer>());
            if(!map.containsKey(id2)) map.put(id2, new HashSet<Integer>());
            map.get(id1).add(id2);
            map.get(id2).add(id1);
        }
        return map;
    }

    public HashMap<Integer, Integer> function2(HashMap<Integer, HashSet<Integer>> map, HashMap<Integer, Integer> depart){
        
        HashMap<Integer, Integer> result = new HashMap<>();
        for(int employeeId : map.keySet()){
            int departId = depart.get(employeeId);
            for(Integer fri : map.get(employeeId)){
                if(depart.get(fri) != departId) result.put(departId, result.getOrDefault(departId, 0) + 1);
            }
        }
        return result;
    }

    public boolean function3(HashMap<Integer, HashSet<Integer>> map){
        HashSet<Integer> visited = new HashSet<>();
        int n = map.size();
        for(Integer id : map.keySet()){
            dfs(id, map, visited);
        }
        return visited.size() == n;
    }

    private void dfs(int id, HashMap<Integer, HashSet<Integer>> map, HashSet<Integer> visited){
        if(visited.contains(id)) return;
        visited.add(id);
        for(Integer fri : map.get(id)){
            dfs(fri, map, visited);
        }
    }

}

class Employee{
    int id;
    int depId;
}
