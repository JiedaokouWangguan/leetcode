import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;

public class Question621{
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                if(i1[0] == i2[0]) return i2[1] - i1[1];
                else return i1[0] - i2[0];
            }
        });
        HashMap<Character, Integer> count = new HashMap<>();
        for(char c : tasks){
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        for(Character key : count.keySet()){
            int curCount = count.get(key);
            pq.offer(new int[]{0, curCount});
        }
        int curTime = 0;
        int result = 0;
        while(pq.size() != 0){
            while(curTime < pq.peek()[0]) curTime += 1;
            int[] curTask = pq.poll();
            curTask[1] -= 1;
            curTime += 1;
            if(curTask[1] == 0) continue;
            curTask[0] += n+1;
            pq.offer(curTask);
        }
        return curTime;

    }
}
