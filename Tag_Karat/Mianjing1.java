import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

// 10.30 - 10:53 - 11.04

/ 问题！！！如果第二题里面i和j有父子关系，答案应该怎么输出

// 复杂的图找爹的题，有个问题是父子关系一定要高清，建立图的时候一定细心是要儿子指向父亲。
// 第一问的时候就可以直接把图建立好，第二问的时候就直接用了。
// 第一问时间复杂度Om，m是边的数量。空间复杂度是On*n，n是点的数量
// 第二问就是线性遍历图，时间复杂度是Om+n，空间复杂度还是ON*N
// 第三问还是线性遍历图，时间复杂度是Om+n，空间复杂度是On*n

public class Mianjing1{
    public List<Integer> function1(List<int[]> edges){
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for(int[] i : edges){
            int from = i[0];
            int to = i[1];
            if(!indegree.containsKey(from)) indegree.put(from, 0);
            if(!indegree.containsKey(to)) indegree.put(to, 0);
            indegree.put(from, indegree.get(from) + 1);
            indegree.put(to, indegree.get(to) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for(Integer key : indegree.keySet()){
            if(indegree.get(key) == 0 || indegree.get(key) == 1) result.add(key);
        }
        return result;
    }

    // 10.37
    // Time complexity is O(m) where m is the number of edges
    // space complexity is O(n) where n is the number of nodes



    // 10.54
    // TIme complexity is O(m) to build graph O(M+N) to iterate through the whole graph
    // Space complexity is O(n+m)
    public List<Integer> getCoAns(List<int[]> edges, int i, int j){
        HashMap<Integer, HashSet<Integer>> graph = buildGraph(edges);
        HashSet<Integer> an1 = new HashSet<>();
        getAllAns(an1, graph, i);
        HashSet<Integer> an2 = new HashSet<>();
        getAllAns(an2, graph, j);

        List<Integer> result = new ArrayList<>();
        for(Integer in : an1){
            if(an2.contains(in)) result.add(in);
        }
        return result;
    }

    private HashMap<Integer, HashSet<Integer>> buildGraph(List<int[]> edges){
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int[] i : edges){
            int parent = i[0];
            int child = i[1];
            if(!graph.containsKey(parent)) graph.put(parent, new HashSet<>());
            if(!graph.containsKey(child)) graph.put(child, new HashSet<>());
            graph.get(child).add(parent);
        }
        return graph;
    }

    private void getAllAns(HashSet<Integer> set, HashMap<Integer, HashSet<Integer>> graph, int id){
        if(!graph.containsKey(id)) return;
        for(Integer parent : graph.get(id)){
            if(set.contains(parent)) continue;
            set.add(parent);
            getAllAns(set, graph, parent);
        }
    }

    private int getFurthest(HashMap<Integer, HashSet<Integer>> graph, int id){
        HashSet<Integer> visited = new HashSet<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int level = 0;
        queue.offer(id);
        while(queue.size() > 0){
            int len = queue.size();
            for(int i = 0;i<len;i++){
                Integer node = queue.poll();
                if(visited.contains(node)) continue;
                visited.add(node);
                for(Integer parent : graph.get(node)){
                    if(visited.contains(parent)) continue;
                    queue.offer(parent);
                }
            }
            level += 1;
        }
        return level - 1;
    }


}
