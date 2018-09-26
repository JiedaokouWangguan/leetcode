import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

// Time complexity is O(n)
// Space complexity is O(n)
// 这个题好复杂。。。但并不难
public class Mianjing13{
    public List<String> getTheOrder(List<String[]> precursorSteps, List<String[]> lastExeTimes){
        HashMap<String, Integer> indegree = new HashMap<>();
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        buildGraph(precursorSteps, indegree, graph);
        HashMap<String, String> lastExe = new HashMap<>();
        
        String root = findRoot(indegree);
        List<String> result = new ArrayList<String>();
        dfs(graph, lastExe, root, null, result);
        return result;
    }

    private void dfs(HashMap<String, HashSet<String>> graph, HashMap<String, String> lastExe, String node, String time, List<String> res){
        if(!graph.containsKey(node) || graph.get(node).size() == 0) return;
        if(time != null && (!lastExe.containsKey(node) || lastExe.get(node).compareTo(time) < 0)) res.add(node);
        
        String latter = time.compareTo(lastExe.get(node)) > 0?time:lastExe.get(node);
        for(String child : graph.get(node)){
            dfs(graph, lastExe, child, latter, res);
        }
    }

    private String findRoot(HashMap<String, Integer> indegree){
        for(String key : indegree.keySet()){
            if(indegree.get(key) == 0) return key;
        }
        return null;
    }

    private void buildLastExet(List<String[]> lastExeTimes, HashMap<String, String> lastExe){
        for(String[] event : lastExeTimes){
            String eve = event[0];
            String time = event[1];
            if(!lastExe.containsKey(eve)) lastExe.put(eve, time);
            else{
                String value = time.compareTo(lastExe.get(eve)) > 0?time:lastExe.get(eve);
                lastExe.put(eve, value);
            }
        }
    }

    private void buildGraph(List<String[]> precurosr, HashMap<String, Integer> indegree, HashMap<String, HashSet<String>> graph){
        for(String[] strs : precurosr){
            String pre = strs[0];
            String next = strs[1];
            if(!indegree.containsKey(pre)) indegree.put(pre, 0);
            indegree.put(next, indegree.getOrDefault(next, 0) + 1);
            if(!graph.containsKey(pre)) graph.put(pre, new HashSet<>());
            graph.get(pre).add(next);
        }
    }
}
