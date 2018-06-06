import java.util.HashMap;

public class Question560{
    public int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            sum[i] = sum[i-1] + nums[i];
        }
        map.put(0, 1);
        int result = 0;
        for(int i= 0;i<nums.length;i++){
            if(map.containsKey(sum[i] - k)){
                result += map.get(sum[i]-k);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return result;
    }
}

// 思路是确定后边界，然后用hashMap的O（1）特性去找前边界。
