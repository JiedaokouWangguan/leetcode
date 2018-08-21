import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayDeque;

public class Question815{
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for(int i = 0;i<routes.length;i++){
            int[] route = routes[i];
            for(int r : route){
                if(!map.containsKey(r)) map.put(r, new HashSet<>());
                map.get(r).add(i);
                visited.put(r, false);
            }
        }
        // 第r个车站，可以坐公交i到达。
        int step = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(S);
        visited.put(S, true);
        while(queue.size() != 0){
            int len = queue.size();
            for(int i = 0;i<len;i++){
                int station = queue.poll();
                if(station == T) return step;
                for(int bus : map.get(station)){
                    for(int nextStation : routes[bus]){
                        if(visited.get(nextStation)) continue;
                        visited.put(nextStation, true);
                        queue.offer(nextStation);
                    }
                }
            }
            step += 1;
        }
        return -1;
    }
}
