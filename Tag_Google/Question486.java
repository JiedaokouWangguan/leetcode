import java.util.HashMap;

public class Question486{
    // 12.09 - 12.13, 5mins
    HashMap<String, Integer> map = new HashMap<>();
    public boolean PredictTheWinner(int[] nums) {
        int result = dp(0, nums.length-1, nums);
        return result > 0;
    }

    private int dp(int begin, int end, int[] nums){
        if(begin == end) return nums[begin];
        String key = begin + "," + end;
        if(map.containsKey(key)) return map.get(key);
        int pickFirst = nums[begin] - dp(begin+1, end, nums);
        int pickLast = nums[end] - dp(begin, end-1, nums);
        int result = Math.max(pickFirst, pickLast);
        map.put(key, result);
        return result;
    }
}
