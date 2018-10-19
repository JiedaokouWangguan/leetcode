import java.util.ArrayDeque;

public class Question224{
    public int calculate(String s) {
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c != ' ') queue.offer(c);
        }
        return cal(queue);
    }

    private int cal(ArrayDeque<Character> queue){
        int sign = 1;
        int result = 0;
        while(queue.size() > 0){
            char p = queue.peek();
            if(p == '+' || p == '-'){
                queue.poll();
                sign = p == '+'?1:-1;
            }
            else if(p >= '0' && p <= '9'){
                int curNum = 0;
                while(queue.size() > 0 && queue.peek() >= '0' && queue.peek() <= '9'){
                    char curChar = queue.poll();
                    curNum = curNum * 10 + (curChar - '0');
                }
                result = result + sign * curNum;
            }
            else if(p == '('){
                queue.poll();
                result = result + sign * cal(queue);
            }
            else{
                queue.poll();
                return result;
            }
        }
        return result;
    }   
}
