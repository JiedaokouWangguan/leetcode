import java.util.Arrays;

public class Question611{
    public int triangleNumber(int[] nums){
        Arrays.sort(nums);
        int result = 0;
        for(int i = nums.length-1;i >= 2;i--){
            int l = 0;
            int r = i-1;
            while(l < r){
                if(nums[l] + nums[r] > nums[i]){
                    result += r-l;
                    r -= 1;
                }
                else{
                    l += 1;
                }
            }
        }
        return result;
    }
}
