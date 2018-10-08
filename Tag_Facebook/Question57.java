import java.util.List;
import java.util.ArrayList;

public class Question57{
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int index = 0;
        while(index < intervals.size() && intervals.get(index).end < newInterval.start)
            result.add(intervals.get(index++));
        while(index < intervals.size() && intervals.get(index).start <= newInterval.end){
            Interval tmp = intervals.get(index++);
            newInterval.start = Math.min(newInterval.start, tmp.start);
            newInterval.end = Math.max(newInterval.end, tmp.end);
        }
        result.add(newInterval);
        while(index < intervals.size())
            result.add(intervals.get(index++));
        return result;
    }
}


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
