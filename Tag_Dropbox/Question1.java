import java.util.Arrays;
import java.util.Comparator;

public class Question1{
    public int[] twoSum(int[] nums, int target) {
        int[][] numss = new int[nums.length][2];
        for(int i = 0;i<nums.length;i++){
            numss[i][0] = nums[i];
            numss[i][1] = i;
        }
        Arrays.sort(numss, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                return i1[0] - i2[0];
            }
        });
        int i = 0;
        int j = nums.length-1;
        int[] result = new int[2];
        while(i < j){
            int sum = numss[i][0] + numss[j][0];
            if(sum == target){
                result[0] = numss[i][1];
                result[1] = numss[j][1];
                return result;
            }
            else if(sum > target) j -= 1;
            else i += 1;
        }
        return result;
    }
}
