import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;

public class Question759{
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(List<Interval> list : schedule){
            for(Interval  i : list){
                if(!map.containsKey(i.start)) map.put(i.start, 0);
                if(!map.containsKey(i.end)) map.put(i.end, 0);
                map.put(i.start, map.get(i.start)+1);
                map.put(i.end, map.get(i.end)-1);
            }
        }
        List<Interval> result = new ArrayList<>();
        int last = -1;
        int sum = 0;
        for(Integer i : map.keySet()){
            int value = map.get(i);
            sum += value;
            if(sum == 0)
                last = i;
            else
                if(last != -1){
                    result.add(new Interval(last, i));
                    last = -1;
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
