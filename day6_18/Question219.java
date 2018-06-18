import java.util.Arrays;
import java.util.Comparator;

public class Question219{
    public boolean containsNearbyDuplicate(int[] nums, int k){
        Integer[] nums1 = new Integer[nums.length];
        for(int i = 0;i<nums.length;i++){
            nums1[i] = i;
        }
        Arrays.sort(nums1, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return nums[i1] - nums[i2];
            }
        });
        for(int i = 1;i<nums1.length;i++){
            if(nums[nums1[i]] == nums[nums1[i-1]]){
                if(Math.abs(nums1[i] - nums1[i-1]) <= k)
                    return true;
            }
        }
        return false;
    }
}
