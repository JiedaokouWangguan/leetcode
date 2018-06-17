import java.util.Arrays;

public class Question581{
    public int findUnsortedSubarray(int[] nums){
        int[] nums1 = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            nums1[i] = nums[i];
        }
        Arrays.sort(nums1);
        int index = 0;
        int result = 0;
        while(index < nums.length && nums1[index] == nums[index]){
            result += 1;
            index += 1;
        }
        if(index == nums.length)
            return 0;
        index = nums.length-1;
        while(index >= 0 && nums1[index] == nums[index]){
            result += 1;
            index -= 1;
        }
        return nums.length - result;
    }
}
