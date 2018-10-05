import java.util.HashMap;
import java.util.HashSet;

public class Question684{
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] edge : edges){
            int v1 = edge[0];
            int v2 = edge[1];
            boolean containsV1 = map.containsKey(v1);
            boolean containsV2 = map.containsKey(v2);
            if(containsV1 && containsV2){
                int root1 = getRoot(map, v1);
                int root2 = getRoot(map, v2);
                if(root1 == root2) return edge;
                map.put(root1, root2);
            }
            else if(!containsV1 && !containsV2){
                map.put(v1, v1);
                map.put(v2, v1);
            }
            else if(containsV1){
                int root1 = getRoot(map, v1);
                map.put(v2, root1);
            }
            else{
                int root2 = getRoot(map, v2);
                map.put(v1, root2);;
            }
        }
        return null;
    }

    private int getRoot(HashMap<Integer, Integer> map, int node){
        while(map.get(node) != map.get(map.get(node))){
            map.put(node, map.get(map.get(node)));
        }
        return map.get(node);
    }
}
