import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

public class Question621{
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : tasks) map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        for(Character c : map.keySet()) pq.offer(map.get(c));
        int count = 0;
        while(pq.size() > 0){
            ArrayList<Integer> tmpList = new ArrayList<>();
            int tmpK = n+1;
            while(tmpK > 0 && pq.size() > 0){
                int tmpInt = pq.poll();
                tmpInt -= 1;
                if(tmpInt > 0) tmpList.add(tmpInt);
                tmpK -= 1;
                count += 1;
            }
            for(Integer i : tmpList) pq.offer(i);
            if(pq.size() == 0) break;
            count += tmpK;
        }
        return count;
    }
}
