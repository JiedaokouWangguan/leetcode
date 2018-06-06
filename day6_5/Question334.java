import java.util.ArrayDeque;

public class Question334{
    public boolean increasingTriplet(int[] nums){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if(nums == null || nums.length < 3){
            return false;
        }

        int index = 0;
        stack.push(nums[index++]);
        while(index < nums.length){
            if(nums[index] > stack.peek()){
                stack.push(nums[index++]);
                if(stack.size() >= 3)
                    return true;
            }
            else{
                while(stack.size() > 0 && stack.peek() >= nums[index]){
                    stack.pop();
                }
                stack.push(nums[index++]);
            }
        }
        if(stack.size() >= 3)
            return true;
        else
            return false;
    }
}
