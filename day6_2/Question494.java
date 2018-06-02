import java.util.HashMap;

public class Question494{
    
    HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
    public int findTargetSumWays(int[] nums, int S){
        return dp(nums, 0, S);
    }
    private int dp(int[] nums, int index, int S){
        if(map.containsKey(index)){
            int ret = map.get(index).getOrDefault(S, -1);
            if(ret != -1)
                return ret;
        }

        if(!map.containsKey(index))
            map.put(index, new HashMap<Integer, Integer>());
        
        if(index == nums.length-1){
            int r = 0;
            if(nums[index] == S) r += 1;
            if(nums[index] == -S) r += 1;
            map.get(index).put(S, r);
            return r;
        }

        int result = dp(nums, index+1, S-nums[index]);
        result += dp(nums, index+1, S+nums[index]);
        map.get(index).put(S, result);
        return result;
    }
}
