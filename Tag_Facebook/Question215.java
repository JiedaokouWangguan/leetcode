import java.util.PriorityQueue;

public class Question215{
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.offer(num);
            if(pq.size()> k) pq.poll();
        }
        return pq.poll();
    }
    public int findKthLargest(int[] nums, int k) {
        int res = 0;
        int begin = 0;
        int end = nums.length-1;
        while((res = select(nums, begin, end)) != k-1){
            if(res > k-1){
                end = res-1;
            }
            else{
                begin = res + 1;
            }
        }
        return nums[k-1];
    }

    private int select(int[] nums, int begin, int end){
        if(begin == end) return begin;
        int value = nums[begin];
        int i = begin + 1;
        int j = end;
        while(i < j){
            while(i < j && nums[j] < value) j --;
            while(i < j && nums[i] > value) i ++;
            if(i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        if(nums[j]> value){
            nums[begin] = nums[j];
            nums[j] = value;
        }
        return j;
    }
}
