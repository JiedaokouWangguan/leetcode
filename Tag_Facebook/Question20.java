import java.util.ArrayDeque;

public class Question20{
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for(int i = 0;i<chars.length;i++){
            char c = chars[i];   
            if(c == '(' || c == '[' || c == '{') stack.push(c);
            else if(stack.size() > 0 && Math.abs(stack.peek() - c) <= 2) stack.pop();
            else return false;   
        }                           
        return stack.size() == 0;                                                                                          
    }
}
