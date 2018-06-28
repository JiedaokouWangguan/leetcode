import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Question368{
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] pre = new int[nums.length];
        int[] count = new int[nums.length];
        
        int max = 0;
        int index = -1;
        for(int i = 0;i<nums.length;i++){
            pre[i] = -1;
            count[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(nums[i] % nums[j] == 0){
                    if(1 + count[j] > count[i]){
                        count[i] = 1 + count[j];
                        pre[i] = j;
                    }
                }
            }
            if(count[i] > max){
                max = count[i];
                index = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        while(index != -1){
            result.add(nums[index]);
            index = pre[index];
        }
        return result;
    }
}
