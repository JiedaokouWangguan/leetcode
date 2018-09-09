import java.util.ArrayDeque;

class HitCounter {
    int len = 0;
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    /** Initialize your data structure here. */
    public HitCounter() {
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        while(queue.size() > 0 && queue.peek()[0]+5*60<timestamp){
            len -= queue.poll()[1];
        }
        len += 1;
        if(queue.size() != 0 && queue.peekLast()[0] == timestamp) queue.peekLast()[1] += 1;
        else queue.offer(new int[]{timestamp, 1});
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(queue.size() > 0 && queue.peek()[0]+5*60<timestamp){
            len -= queue.poll()[1];
        }
        return len;
    }
}
