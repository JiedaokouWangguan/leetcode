import java.util.Arrays;
import java.util.Comparator;

public class Question252{
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length < 2)
            return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override 
            public int compare(Interval i1, Interval i2){
                if(i1.start == i2.start)
                    return i1.end - i2.end;
                return i1.start - i2.start;
            }
        });
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i].start < intervals[i-1].end)
                return false;
        }
        return true;
    }
}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
