import java.util.ArrayDeque;

public class Question334{
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3)
            return false;
        int[] curMin = new int[nums.length];
        curMin[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            curMin[i] = Math.min(curMin[i-1], nums[i]);
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = nums.length-1;i >=0;i--){
            while(stack.size() != 0 && stack.peek() <= curMin[i]){
                stack.pop();
            }
            if(stack.size() != 0 && stack.peek() > nums[i] && nums[i] > curMin[i])
                return true;
            stack.push(nums[i]);
        }
        return false;
    }
}
