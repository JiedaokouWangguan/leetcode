import java.util.TreeMap;

public class Question253{
    // 2.14 - 2.18
    public int minMeetingRooms(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Interval i : intervals){
            map.put(i.start, map.getOrDefault(i.start, 0)+1);
            map.put(i.end, map.getOrDefault(i.end, 0)-1);
        }

        int result = 0;
        int cur= 0;
        for(Integer key : map.keySet()){
            cur += map.get(key);
            result = Math.max(result, cur);
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
