import java.util.Arrays;

public class Question698{
    boolean tag = false;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;
        int sum = 0;
        if(k == 1) return true;
        if(k > nums.length) return false;
        int max = 0;
        for(int n : nums){
            sum += n;
            max = Math.max(max, n);
        }
        if(sum % k != 0) return false;
        if(max > sum/k) return false;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, visited, 0, sum/k, k);
        return tag;
    }

    private void backtrack(int[] nums, boolean[] visited, int cur, int target, int k){
        if(cur > target) return;
        if(cur == target){
            if(k == 1) tag = true;
            else backtrack(nums, visited, 0, target, k-1);
            return;
        }
        for(int i = nums.length-1;i>=0;i--){
            if(visited[i]) continue;
            if(nums[i] + cur > target) continue;
            visited[i] = true;
            backtrack(nums, visited, cur+nums[i], target, k);
            if(tag) return;
            visited[i] = false;
        }
    }
}
