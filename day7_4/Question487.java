import java.util.Queue;
import java.util.LinkedList;

public class Question487{
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, zero = 0, k = 1; // flip at most k zero
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) zero++;
            while (zero > k)
                if (nums[l++] == 0) zero--;
            max = Math.max(max, h - l + 1);
        }
        return max;
    }
    public int findMaxConsecutiveOnesFollowUp(int[] nums) {                 
        int max = 0, k = 1; // flip at most k zero
        Queue<Integer> zeroIndex = new LinkedList<>(); 
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0)
                zeroIndex.offer(h);
            if (zeroIndex.size() > k)                                   
                l = zeroIndex.poll() + 1;
            max = Math.max(max, h - l + 1);
        }
        return max;                     
    }
}
