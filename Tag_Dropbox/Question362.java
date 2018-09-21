import java.util.ArrayDeque;

class HitCounter {
    int count = 0;
    ArrayDeque<int[]> deque = new ArrayDeque<>();
    /** Initialize your data structure here. */
    public HitCounter() {
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        count += 1;
        if(deque.size() == 0 || deque.peekLast()[0] != timestamp){
            int[] cur = new int[]{timestamp, 1};
            deque.offer(cur);
        }
        else{
            deque.peekLast()[1] += 1;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(deque.size() > 0 && deque.peek()[0] <= timestamp-300){
            int[] cur = deque.poll();
            count -= cur[1];
        }
        return count;
    }
}
