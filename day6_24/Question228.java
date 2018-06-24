import java.util.List;
import java.util.ArrayList;

public class Question228{
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums == null || nums.length == 0)
            return result;
        int lastIndex = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == nums[i-1] + 1){
                continue;
            }
            
            if(lastIndex == i-1){
                result.add(""+nums[lastIndex]);
                lastIndex = i;
            }
            else{
                result.add(nums[lastIndex] + "->" + nums[i-1]);
                lastIndex = i;
            }
        }
        if(lastIndex == nums.length-1)
            result.add(""+nums[lastIndex]);
        else
            result.add(nums[lastIndex] + "->" + nums[nums.length-1]);
        return result;
    }
}
