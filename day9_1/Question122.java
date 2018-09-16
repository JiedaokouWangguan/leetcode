public class Question122{
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int result = 0;
        int n = prices.length;
        for(int i = 1;i <n;i++) result += prices[i] - prices[i-1] > 0?prices[i] - prices[i-1]:0;
        return result;
    }
}
