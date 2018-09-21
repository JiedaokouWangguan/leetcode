import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;

public class Question347{
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                return i1[1]-i2[1];
            }
        });
        for(int key : map.keySet()){
            int value = map.get(key);
            pq.offer(new int[]{key, value});
            if(pq.size() > k) pq.poll();
        }

        List<Integer> result = new LinkedList<>();
        while(pq.size() > 0){
            int[] cur = pq.poll();
            result.add(0, cur[0]);
        }
        return result;
    }
}
