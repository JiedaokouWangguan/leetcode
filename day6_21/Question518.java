import java.util.Arrays;

public class Question518{
    public int change(int amount, int[] coins) {
        if(amount == 0)
            return 1;
        if(coins == null || coins.length == 0)
            return 0;
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0;i<coins.length;i++){
            for(int j = 0;j<amount+1;j++){
                dp[i][j] = -1;
            }
        }
        return getResult(amount, coins, dp, 0);
    }

    private int getResult(int amount, int[] coins, int[][] dp, int index){
        if(dp[index][amount] != -1)
            return dp[index][amount];
        int result = 0;
        for(;index<coins.length;index++){
            if(amount>coins[index]){
                result += getResult(amount-coins[index], coins, dp, index);
            }
            else if(amount == coins[index]){
                result += 1;
            }
            else{
                break;
            }
        }
        dp[index][amount] = result;
        return result;
    }

}
