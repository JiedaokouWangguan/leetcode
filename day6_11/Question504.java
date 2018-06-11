import java.util.ArrayDeque;

public class Question504{
    public String convertToBase7(int num){
        if(num == 0)
            return "" + 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean isPos = num > 0;
        if(!isPos)
            num = -num;

        while(num > 0){
            stack.push(num%7);
            num /= 7;
        }
        String result = isPos?"":"-"; 
        while(stack.size() != 0){
            result += stack.pop();
        }
        return result;
    }
}
