import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

class Solution {
    int[] nums;
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    Random random = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            if(!map.containsKey(num))
                map.put(num, new ArrayList<Integer>());
            map.get(num).add(i);
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
