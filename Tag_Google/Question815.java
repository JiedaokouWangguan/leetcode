import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayDeque;

public class Question815{
    // 11.13 - 11.25, 13mins
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T) return 0;
        HashMap<Integer, HashSet<Integer>> stop2bus = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> bus2stop = new HashMap<>();
        for(int i = 0;i<routes.length;i++){
            bus2stop.put(i, new HashSet<Integer>());
            for(int stop : routes[i]){
                bus2stop.get(i).add(stop);
                if(!stop2bus.containsKey(stop)) stop2bus.put(stop, new HashSet<Integer>());
                stop2bus.get(stop).add(i);
            }                           
        }                               
        ArrayDeque<Integer> buses = new ArrayDeque<>();                                                                                 
        boolean[] visited = new boolean[routes.length];
        for(int bus : stop2bus.get(S)){
            visited[bus] = true;        
            buses.offer(bus);           
        }                               
        int step = 1;                   
        while(buses.size() > 0){        
            int len = buses.size();  
            for(int i = 0;i<len;i++){
                int curBus = buses.poll();
                if(bus2stop.get(curBus).contains(T)) return step;
                for(int curStop : bus2stop.get(curBus)){
                    for(int nextBus : stop2bus.get(curStop)){
                        if(visited[nextBus]) continue;
                        buses.offer(nextBus);
                        visited[nextBus] = true;
                    }                   
                }                       
            }                           
            step += 1;                  
        }                               
        return -1;                      
    }
}
