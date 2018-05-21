package leetcode.day5_20;

/**
 * Created by Song on 2018/5/19.
 */
public class Question198
{
    /*
    public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}

public void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
     */
    public void rotate(int[] nums, int k)
    {
        int[] tmp = new int[k];
        for (int i = nums.length-k;i<nums.length;i++)
        {
            tmp[i - (nums.length-k)] = nums[i];
        }
        for (int i = nums.length-1;i>=k;i--)
        {
            nums[i] = nums[i-k];
        }
        for (int i = 0;i<k;i++)
        {
            nums[i] = tmp[i];
        }
    }
}
