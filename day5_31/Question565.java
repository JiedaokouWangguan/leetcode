public class Question565{
    public int arrayNesting(int[] nums){
        int n = nums.length;
        boolean[] visited = new boolean[n];

        int maxLength = 0;
        for(int i = 0;i<nums.length;i++){
            if(!visited[i]){
                int tmpResult = dfs(nums, visited, i);
                maxLength = Math.max(maxLength, tmpResult);
            }
        }
        return maxLength;
    }

    private int dfs(int[] nums, boolean[] visited, int index){
        if(visited[index])
            return 0;

        visited[index] = true;
        return dfs(nums, visited, nums[index]) + 1;
    }
}
