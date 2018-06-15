import java.util.HashSet;

public class Question421{
    public int findMaximumXOR(int[] nums){
        int mask = 0;
        int max = 0;
        for(int i = 31;i>=0;i--){
            mask = mask | (1 << i);
            HashSet<Integer> set = new HashSet<>();
            for(int num : nums)
                set.add(num & mask);
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(prefix ^ tmp)){
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
