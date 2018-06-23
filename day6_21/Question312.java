import java.util.HashMap;

public class Question312{
    public int maxCoins(int[] nums) {
        int[] nn = new int[nums.length+2];
        int n = 1;
        for(int num : nums){
            if(num > 0)
                nn[n++] = num;
        }
        nn[0] = 1;
        nn[n++] = 1;
        
        int[][] mem = new int[n][n];
        return dp(mem, nn, 0, n-1);
    }

    private int dp(int[][] mem, int[] nn, int left, int right){
        if(left + 1 == right)
            return 0;
        if(mem[left][right] > 0)
            return mem[left][right];
        int result = 0;
        for(int i = left + 1;i < right ;i++){
            result = Math.max(dp(mem, nn, left, i) + dp(mem, nn, i, right) + nn[left] * nn[i] * nn[right], result);
        }
        mem[left][right] = result;
        return result;
    }
}
