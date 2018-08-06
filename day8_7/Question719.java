import java.util.Arrays;

public class Question719{
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int begin = 0;
        int end = nums[nums.length - 1] - nums[0];
        while (begin < end) {
            int mid = (end - begin) / 2 + begin;
            int count = 0;
            for (int i = 0, j = 0; i < nums.length; i++) {
                while (j < nums.length && nums[j] - nums[i] <= mid)
                    j += 1;
                count += j - i - 1;
            }
            if (count < k) begin = mid + 1;
            else end = mid;
        }
        return begin;
    }
}
