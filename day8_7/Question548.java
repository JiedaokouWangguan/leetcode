import java.util.HashSet;

public class Question548{
    public boolean splitArray(int[] nums) {
        if(nums.length < 7) return false;
        int[] sum = new int[nums.length];
        int s = 0;
        for(int i = 0;i<nums.length;i++){
            s += nums[i];
            sum[i] = s;
        }
        for(int i = 3; i< nums.length-3;i++){
            boolean tmpResult = checkValue(sum, i+1, nums.length-1, getValue(sum, 0, i-1));
            if(tmpResult) return true;
        }
        return false;
    }

    private HashSet<Integer> getValue(int[] sum, int begin, int end){
        if(end - begin < 2) return null;
        HashSet<Integer> set = new HashSet<>();
        for(int i = begin+1;i<end;i++){
            if(sum[i-1] == sum[end] - sum[i]) set.add(sum[i]);
        }
        return set;
    }

    private boolean checkValue(int[] sum, int begin, int end, HashSet<Integer> set){
        if(set == null || set.size() == 0) return false;
        for(int i = begin + 1;i<end;i++){
            if(sum[i-1] - sum[begin-1] == sum[end] - sum[i] && set.contains(sum[end] - sum[i]))
                return true;
        }
        return false;
    }
}
