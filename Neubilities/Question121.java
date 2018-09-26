public class Question121{
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int result = 0;
        for(int i : prices){
            if(i >= buy) result = Math.max(result, i - buy);
            else buy = i;
        }
        return result;
    }
}
