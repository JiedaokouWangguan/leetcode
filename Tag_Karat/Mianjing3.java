import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

// Time complexity is O(n), Space complexity is O(n)
// 拓扑排序时间复杂度是O(n+e)因为每个定点进入出来各一次，每个点的入度减1的操作一共有e次
public class Mianjing3{
    public List<List<String>> taskByLevel(String[][] input){
        HashMap<String, Integer> indegree = new HashMap<>();
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        buildGraph(input, graph, indegree);
        ArrayDeque<String> queue = new ArrayDeque<>();
        for(String key : indegree.keySet()){
            if(indegree.get(key) == 0){
                queue.offer(key);
                indegree.put(key, -1);
            }
        }
        List<List<String>> list = new ArrayList<>();
        while(queue.size() > 0){
            List<String> tmpResult = new ArrayList<>();
            int len = queue.size();
            for(int i = 0;i<len;i++){
                String str = queue.poll();
                tmpResult.add(str);
                for(String s : graph.get(str)){
                    if(indegree.get(s) == -1) continue;
                    indegree.put(s, indegree.get(s) - 1);
                    if(indegree.get(s) == 0){
                        indegree.put(s, -1);
                        queue.offer(s);
                    }
                }
            }
            list.add(tmpResult);
        }
        return list;
    }

    private void buildGraph(String[][] input, HashMap<String, HashSet<String>> graph, HashMap<String, Integer> indegree){
        for(String[] edge : input){
            String from = edge[0];
            String to = edge[1];
            if(!graph.containsKey(from)) graph.put(from, new HashSet<>());
            if(!graph.containsKey(to)) graph.put(to, new HashSet<>());
            if(!indegree.containsKey(from)) indegree.put(from, 0);
            if(!indegree.containsKey(to)) indegree.put(to, 0);
            graph.get(from).add(to);
            indegree.put(to, indegree.get(to) + 1);
        }
    }
}
