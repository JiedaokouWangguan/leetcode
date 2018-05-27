import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Question496{
    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int n : nums2)
        {
            if(stack.size() == 0 || n <= stack.peek())
                stack.push(n);
            else
            {
                while(stack.size() != 0 && n > stack.peek())
                {
                    int tmp = stack.pop();
                    map.put(tmp, n);
                }
                stack.push(n);
            }
        }
        int[] result = new int[nums1.length];
        for(int i = 0;i<nums1.length;i++)
        {
            int n = nums1[i];
            result[i] = map.getOrDefault(n, -1);
        }
        return result;
    }
}
