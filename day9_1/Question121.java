public class Question121{
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int max = prices[n-1];
        int result = 0;
        for(int i = n-2;i>=0;i--){
            max = Math.max(max, prices[i]);
            result = Math.max(result, max - prices[i]);
        }                
        return result;  
    }
}
