import java.util.List;
import java.util.ArrayList;

public class Question310{
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n == 0) return result;
        if(n == 1){
            result.add(0);
            return result;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for(int i = 0;i<graph.size();i++){
            if(graph.get(i).size() == 1)
                result.add(i);
        }
        while(n > 2){
            List<Integer> newResult = new ArrayList<>();
            n -= result.size();
            for(Integer i : result){
                Integer j = graph.get(i).get(0);
                graph.get(j).remove(i);
                if(graph.get(j).size() == 1)
                    newResult.add(j);
            }
            result = newResult;
        }
        return result;
    }
}
