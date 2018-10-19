import java.util.List;
import java.util.TreeMap;
import java.util.ArrayList;

public class Question759{
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for(List<Interval> list : schedule){
            for(Interval i : list){
                int s = i.start;
                int e = i.end;
                count.put(s, count.getOrDefault(s, 0) + 1);
                count.put(e, count.getOrDefault(e, 0) - 1);
            }
        }

        List<Interval> result = new ArrayList<>();
        Integer last = null;
        int cur = 0;
        for(Integer key : count.keySet()){
            cur += count.get(key);
            if(cur != 0) {
                if(last != null){
                    result.add(new Interval(last, key));
                    last = null;
                }
            }
            else{
                if(last == null){
                    last = key;
                }
            }
        }
        return result;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
