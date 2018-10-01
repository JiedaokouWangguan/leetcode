import java.util.HashMap;

public class Question312{
    // 9.35 - 9.53, 19mins
    HashMap<String, Integer> map = new HashMap<>();
    public int maxCoins(int[] nums) {
        return helper(0, nums.length-1, nums);
    }

    private int helper(int begin, int end, int[] nums){
        String key = begin + "," + end;
        if(map.containsKey(key)) return map.get(key);
        int max = 0;
        for(int i = begin;i<=end;i++){
            int tmp = getValue(begin-1, nums) * getValue(i, nums) * getValue(end+1, nums);
            if(i > begin) tmp += helper(begin, i-1, nums);
            if(i < end) tmp += helper(i+1, end, nums);
            max = Math.max(max, tmp);
        }
        map.put(key, max);
        return max;
    }

    private int getValue(int index, int[] nums){
        if(index == -1 || index == nums.length) return 1;
        else return nums[index];
    }
}
