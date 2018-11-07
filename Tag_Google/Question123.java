public class Question123{
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;                                                               
        int n = prices.length;                            
        int[][] buy = new int[3][n];                      
        int[][] sell = new int[3][n];                     
        buy[1][0] = -prices[0];
        buy[2][0] = -prices[0];
        for(int i = 1;i<=2;i++){                          
            for(int j = 1;j<n;j++){                       
                buy[i][j] = Math.max(buy[i][j-1], sell[i-1][j-1] - prices[j]);
                sell[i][j] = Math.max(sell[i][j-1], buy[i][j-1] + prices[j]);
            }                                             
        }  
        return sell[2][n-1];                              
    }
}
