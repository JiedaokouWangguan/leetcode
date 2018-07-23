import java.util.Arrays;

public class Question473{

    boolean result = false;
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        int max = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, n);
        }
        if (sum % 4 != 0) return false;
        int edge = sum / 4;
        if (max > edge) return false;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        visited[nums.length - 1] = true;
        backtrack(nums, visited, edge - nums[nums.length - 1], 4, edge);
        return result;
    }
    private void backtrack(int[] nums, boolean[] visited, int target, int subsetIndex, int edge) {
        if (target == 0) {
            if (subsetIndex == 1) result = true;
            else backtrack(nums, visited, edge, subsetIndex - 1, edge);
        } else {
            for (int i = nums.length - 2; i >= 0; i--) {
                if (visited[i]) continue;
                visited[i] = true;
                if (target >= nums[i])
                    backtrack(nums, visited, target - nums[i], subsetIndex, edge);
                visited[i] = false;
                if (result) return;
            }
        }
    }
}
