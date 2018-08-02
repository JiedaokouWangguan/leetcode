import java.util.PriorityQueue;

class KthLargest{
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n : nums){
            if(pq.size() < k || n > pq.peek()) pq.offer(n);
            if(pq.size() > k) pq.poll();
        }
    }

    public int add(int val) {
        if(pq.size() < k || val > pq.peek()) pq.offer(val);
        if(pq.size() > k) pq.poll();
        return pq.peek();
    }
}
