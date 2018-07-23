public class Question698{
    boolean tag = false;                 
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) return true;
        if (k > n) return false;
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % k != 0) return false;
        int subsetSum = sum / k;
        if (max > subsetSum) return false;
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);
        backtrack(nums, visited, subsetSum, k, subsetSum);
        return tag;
    }

    private void backtrack(int[] nums, boolean[] visited, int target, int subsetIndex,
            int subsetSum) {
        if (tag) return;
        if (target == 0) {
            if (subsetIndex == 1) tag = true;
            else backtrack(nums, visited, subsetSum, subsetIndex - 1, subsetSum);
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (visited[i]) continue;
                if (target >= nums[i]) {
                    visited[i] = true;
                    backtrack(nums, visited, target - nums[i], subsetIndex, subsetSum);
                    visited[i] = false;
                    if (tag) return;
                }
            }
        }
    } 
}
