import java.util.ArrayDeque;

public class Question239{

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 1) return nums;
        MyQueue mq = new MyQueue();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < k - 1; i++) {
            mq.push(nums[index++]);
        }
        while (index < nums.length) {
            mq.push(nums[index++]);
            result[index - k] = mq.getMax();
            mq.pop();
        }
        return result;
    }           
}
class MyQueue{        
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    public void push(int a){ 
        int count = 0;
        while(queue.size() != 0 && a > queue.peekLast()[0]){
            count += queue.peekLast()[1] + 1;                                     
            queue.pollLast();
        }             
        queue.offer(new int[]{a, count});
    }                 
    public int size(){
        return queue.size();
    }                 
    public int getMax(){
        return queue.peek()[0];
    }                 

    public int pop(){
        if(queue.peek()[1] == 0) return queue.pop()[0];
        else {        
            queue.peek()[1] -= 1;
            return queue.peek()[0];
        }             
    }                 
}                   
