import java.util.Arrays;

public class Question31{
    public void nextPermutation(int[] nums) {
        int index = nums.length-1;
        while(index > 0 && nums[index]<= nums[index-1]){
            index -= 1;
        }
        if(index == 0) {
            Arrays.sort(nums);
            return;
        }
        int tmpIndex = index-1;
        while(index < nums.length && nums[index] > nums[tmpIndex]){
            index += 1;
        }
        index -= 1;
        int tmp = nums[tmpIndex];
        nums[tmpIndex] = nums[index];
        nums[index] = tmp;
        Arrays.sort(nums, tmpIndex+1, nums.length);
    }
}
