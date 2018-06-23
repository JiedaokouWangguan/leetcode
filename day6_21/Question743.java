import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class Question743{
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] minTime = new int[N+1];
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int[] time:times){
            int from = time[0];
            int to = time[1];
            int cost = time[2];
            if(!map.containsKey(from))
                map.put(from, new HashMap<Integer, Integer>());
            map.get(from).put(to, cost);
        }
        Arrays.fill(minTime, Integer.MAX_VALUE);
        ArrayDeque<Job> queue = new ArrayDeque<>();
        Job job = new Job(K, 0);
        queue.offer(job);
        minTime[K] = 0;
        int maxTime = -1;
        while(queue.size() != 0){
            Job tmp = queue.pop();
            if(!map.containsKey(tmp.toId))
                continue;
            for(int key : map.get(tmp.toId).keySet()){
                int to = key;
                int cost = map.get(tmp.toId).get(to);
                if(tmp.timeSpent + cost  < minTime[to]){
                    minTime[to] = tmp.timeSpent + cost;
                    queue.offer(new Job(to, minTime[to]));
                }
            }      
        }
        for(int i = 1;i< minTime.length;i++){
            int num = minTime[i];
            if(num == Integer.MAX_VALUE)
                return -1;
            else
                maxTime = Math.max(maxTime, num);
        }
        return maxTime;
    }
}

class Job{
    int toId;
    int timeSpent;
    public Job(int t, int ti){
        toId = t;
        timeSpent = ti;
    }
}
