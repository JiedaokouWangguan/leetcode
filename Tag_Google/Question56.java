import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Question56{
    // 11.27 - 11.30, 4mins
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                if(i1.start == i2.start) return i1.end - i2.end;
                else return i1.start - i2.start;
            }
        });

        Interval last = null;
        List<Interval> result = new ArrayList<>();
        for(Interval i : intervals){
            if(last == null){
                last = i;
                continue;
            }

            if(last.end >= i.start){
                last.end = Math.max(i.end, last.end);
            }
            else{
                result.add(last);
                last = i;
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
