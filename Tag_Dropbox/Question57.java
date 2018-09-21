import java.util.List;
import java.util.LinkedList;

public class Question57{
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();    
        int index = 0;                                      
        while(index < intervals.size() && newInterval.start > intervals.get(index).end) result.add(intervals.get(index++));
        if(index < intervals.size()) newInterval.start = Math.min(newInterval.start, intervals.get(index).start);
        while(index < intervals.size() && intervals.get(index).end < newInterval.end) index += 1;
        if(index < intervals.size() && newInterval.end >= intervals.get(index).start) newInterval.end = Math.max(newInterval.end, intervals.get(index++).end);                            
        result.add(newInterval);                            
        while(index < intervals.size()) result.add(intervals.get(index++));
        return result;                                      
    }
    // 1-2  4-5   
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
