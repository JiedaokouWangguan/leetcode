import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.HashSet;
public class Question582{
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0;i<pid.size();i++){
            if(!map.containsKey(ppid.get(i)))
                map.put(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(kill);
        HashSet<Integer> set = new HashSet<>();
        while(queue.size() != 0){
            Integer tmp = queue.poll();
            set.add(tmp);
            if(!map.containsKey(tmp))
                continue;
            for(Integer i : map.get(tmp)){
                if(!set.contains(i))
                    queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(Integer i : set)
            result.add(i);
        return result;
    }
}
