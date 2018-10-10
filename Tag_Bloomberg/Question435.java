import java.util.Arrays;
import java.util.Comparator;

public class Question435{
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                if(i1.end == i2.end) return i2.start - i1.start;
                else return i1.end - i2.end;
            }
        });

        Interval last = null;
        int num = 0;
        for(int i = 0;i<intervals.length;i++){
            if(last == null || intervals[i].start >= last.end){
                last = intervals[i];
                num += 1;
            }
        }
        return intervals.length - num;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
