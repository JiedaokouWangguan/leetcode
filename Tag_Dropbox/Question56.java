import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Question56{
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return result;

        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        for(Interval i : intervals) pq.offer(i);
        Interval last = null;
        while(pq.size() > 0){
            Interval cur = pq.poll();
            if(last == null) last = cur;
            else{
                if(last.end >= cur.start) last.end = Math.max(last.end, cur.end);
                else{
                    result.add(last);
                    last = cur;
                }
            }
        }
        if(last != null) result.add(last);
        return result;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
