import java.util.HashMap;

public class Question523{
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            if(k != 0) sum %= k;
            if(map.containsKey(sum)){
                int lastIndex = map.get(sum);
                if(i - lastIndex > 1) return true;
            }
            else map.put(sum, i);
        }                   
        return false;       
    }   
}
