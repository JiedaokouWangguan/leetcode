import java.util.TreeSet;

public class Question220{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k <= 0) return false;
        final TreeSet<Long> values = new TreeSet<>();
        for(int ind = 0;ind <nums.length;ind++){
            Long floor = values.floor((long)nums[ind]+t);
            Long ceil = values.ceiling((long)nums[ind]-t);
            if((floor != null && floor >= nums[ind]) || (ceil != null && ceil <= nums[ind]))
                return true;
            values.add((long)nums[ind]);
            if(ind >= k) values.remove((long)nums[ind-k]);
        }
        return false;
    }
}
