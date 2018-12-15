import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class Question496{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = nums2.length-1;i>=0;i--){
            while(stack.size() > 0 && nums2[i] > nums2[stack.peek()]){
                stack.pop();
            }
            if(stack.size() != 0){
                map.put(nums2[i], nums2[stack.peek()]);
            }
            stack.push(i);
        }
        int[] result = new int[nums1.length];
        for(int i = 0;i<nums1.length;i++){
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
