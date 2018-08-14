import java.util.ArrayDeque;

public class Question32{
    public int longestValidParentheses(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        char[] chars = s.toCharArray();
        for(int i = 0;i<chars.length;i++){
            if(stack.size() == 1) stack.push(i);
            else if(chars[stack.peek()] == '(' && chars[i] == ')') stack.pop();
            else stack.push(i);
        }
        int result = 0;
        int lastIndex = chars.length;
        while(stack.size() != 0){
            int cur = stack.pop();
            result = Math.max(result, lastIndex - cur - 1);
            lastIndex = cur;
        }
        return result;
    }
}
