import java.util.Comparator;
import java.util.PriorityQueue;

public class Question436{
    public int[] findRightInterval(Interval[] intervals){
        PriorityQueue<IndexInterval> pq1 = new PriorityQueue<>(new Comparator<IndexInterval>(){
            @Override
            public int compare(IndexInterval i1, IndexInterval i2){
                return i1.interval.start - i2.interval.start;
            }
        });
        PriorityQueue<IndexInterval> pq2 = new PriorityQueue<>(new Comparator<IndexInterval>(){
            @Override
            public int compare(IndexInterval i1, IndexInterval i2){
                return i1.interval.end - i2.interval.end;
            }
        });

        for(int i = 0;i<intervals.length;i++){
            pq1.offer(new IndexInterval(i, intervals[i]));
        }

        int[] result = new int[intervals.length];
        while(pq1.size() != 0){
            IndexInterval i = pq1.poll();
            while(pq2.size() != 0 && pq2.peek().interval.end <= i.interval.start){
                result[pq2.poll().index] = i.index;
            }
            pq2.offer(i);
        }
        while(pq2.size() != 0){
            result[pq2.poll().index] = -1;
        }
        return result;
    }
}

class IndexInterval{
    int index;
    Interval interval;
    IndexInterval(int i, Interval in){
        index = i;
        interval = in;
    }
}

class Interval{
    int start;
    int end;
    Interval(){
        start = 0;
        end = 0;
    }
    Interval(int s, int e){
        start = s;
        end = e;
    }
}
