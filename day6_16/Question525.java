import java.util.HashMap;

public class Question525{
    public int findMaxLength(int[] nums){
        int cur = 0;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            cur += num == 0?-1:1;
            if(map.containsKey(cur)){
                result = Math.max(i - map.get(cur), result);
            }
            else{
                map.put(cur, i);
            }
        }
        return result;
    }
}
