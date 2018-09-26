import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
// 8.30 - 8.45
// time complexity is O(nlogn)
// space complexity is O(n)
// 简单的priorityqueue的使用，时间复杂度是onlogn因为pq实际是在做排序
public class Mianjing10{
    public List<int[]> mergeInterval(List<int[]> durations){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                return i1[0] - i2[0];
            }
        });

        for(int[] i : durations) pq.offer(i);
        List<int[]> merged  = new ArrayList<>();
        
        int[] last = null;
        while(pq.size() > 0){
            int[] cur = pq.poll();
            if(last != null){
                if(cur[0] <= last[1]) last[1] = Math.max(last[1], cur[1]);
                else{
                    merged.add(last);
                    last = cur;
                }
            }
            else
                last = cur;
        }
        if(last != null) merged.add(last);

        int lastTime = 0;
        List<int[]> result = new ArrayList<>();
        for(int[] i: merged){
            if(lastTime < i[0]){
                result.add(new int[]{lastTime, i[0]-1});
            }
            lastTime = i[1];
        }
        return result;
    }
}
