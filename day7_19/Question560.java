import java.util.HashMap;

public class Question560{
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0;
        for(int n : nums){
            sum += n;
            result += map.getOrDefault(sum-k, 0);
            if(!map.containsKey(sum)) map.put(sum, 0);
            map.put(sum, map.get(sum) + 1);
        }
        return result;
    }
}
