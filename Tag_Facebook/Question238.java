import java.util.Arrays;

public class Question238{
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length]; 
        Arrays.fill(result, 1);
        int pro = 1;
        for(int i = nums.length-1;i>=0 ; i--){
            result[i] *= pro;
            pro *= nums[i];
        }
        pro = 1;
        for(int i = 0;i<nums.length;i++){
            result[i] *= pro;
            pro *= nums[i];
        }
        return result;
    }
}
