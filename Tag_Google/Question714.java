public class Question714{
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0] - fee;
        for(int i = 1;i<n;i++){
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]-fee);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return sell[n-1];
    }
}
