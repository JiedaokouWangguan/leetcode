import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Question503{
    public int[] nextGreaterElements(int[] nums)
    {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[nums.length];
        int length = nums.length;
        Arrays.fill(result, -1);
        for(int i = 0;i<length * 2 ;i++)
        {
            if(stack.size() == 0 || nums[i % length] <= nums[stack.peek()])
            {
                stack.push(i % length);
            }
            else
            {
                while(stack.size() != 0 && nums[i % length] > nums[stack.peek()])
                {
                    int tmpIndex = stack.pop();
                    result[tmpIndex] = nums[i % length];
                }
                stack.push(i % length);
            }
        }
        return result;
    }

}
