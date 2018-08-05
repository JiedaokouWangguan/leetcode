import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.end - i2.end;
            }
        });

        int end = intervals[0].end;
        int count = 1;

        for(int i = 1;i<intervals.length;i++){
            if(intervals[i].start >= end){
                end = intervals[i].end;
                count += 1;
            }
        }
        return intervals.length - count;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
