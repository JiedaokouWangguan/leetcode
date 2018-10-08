import java.util.HashMap;

public class Question560{
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;  
        int result = 0;
        for(int num : nums){
            sum += num;

            result += map.getOrDefault(sum - k, 0);    
            map.put(sum, map.getOrDefault(sum, 0) + 1);                                                       
        }             
        return result;
    } 
}
