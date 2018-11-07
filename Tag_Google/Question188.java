public class Question188{
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;  
        if(k>=n/2) return quickSolve(prices);

        int[][] buy = new int[k+1][n];                      
        int[][] sell = new int[k+1][n];                     

        for(int i = 1;i<=k;i++){
            buy[i][0] = -prices[0];
            for(int j = 1;j<n;j++){                       
                buy[i][j] = Math.max(buy[i][j-1], sell[i-1][j-1] - prices[j]);
                sell[i][j] = Math.max(sell[i][j-1], buy[i][j-1] + prices[j]);
            }                                             
        }  
        return sell[k][n-1]; 
    }
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
