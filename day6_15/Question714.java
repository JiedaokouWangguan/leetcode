import java.util.ArrayDeque;

public class Question714{
    public int maxProfit(int[] prices, int fee){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for(int i = 0;i<prices.length;i++){
            if(stack.size() == 0){
                stack.push(prices[i]);
            }
            else{
                if(prices[i] < stack.peek()){
                    int sell = stack.pop();
                    int buy = -1;
                    while(stack.size() != 0){
                        buy = stack.pop();
                    }
                    if(buy != -1 && sell - buy > fee){
                        result += sell - buy;
                    }
                }
                stack.push(prices[i]);
            }
        }
        int sell = stack.pop();
        int buy = -1;
        while(stack.size() != 0){
            buy = stack.pop();
        }
        if(buy != -1 && sell - buy > fee){
            result += sell - buy;
        }
        return result;
    }
}
