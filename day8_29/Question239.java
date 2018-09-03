package leetcode.day8_29;

import java.util.ArrayDeque;

public class Question239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        MyQueue mq = new MyQueue();
        int i = 0;
        int[] result = new int[nums.length - k + 1];
        for (;i<k-1;i++) mq.offer(nums[i]);
        for (;i<nums.length;i++){
            mq.offer(nums[i]);
            result[i - k + 1] = mq.poll();
        }
        return result;
    }
}

class MyQueue{
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    public void offer(int i){
        int[] cur = new int[]{i, 1};
        while (queue.size() > 0 && i > queue.peekLast()[0]){
            cur[1] += queue.pollLast()[1];
        }
        queue.offer(cur);
    }
    public int poll(){
        int res = queue.peek()[0];
        if (queue.peek()[1] == 1) queue.poll();
        else queue.peek()[1] -= 1;
        return res;
    }
}
