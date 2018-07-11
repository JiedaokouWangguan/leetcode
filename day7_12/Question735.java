import java.util.ArrayDeque;

public class Question735{
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(Integer a : asteroids){
            if(stack.size() == 0 || a > 0) stack.push(a);
            else{
                if(stack.peek() < 0){
                    stack.push(a);
                    continue;
                }
                while(stack.size() > 0 && stack.peek() > 0 && stack.peek() < -a)
                    stack.pop();
                if(stack.size() > 0 && stack.peek() == -a) stack.pop();
                else if(stack.size() == 0 || stack.peek() < 0) stack.push(a);
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length-1;i>=0;i--)
            result[i] = stack.pop();
        return result;
    }
}
