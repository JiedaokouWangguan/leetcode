import java.util.ArrayDeque;

public class Question42{
    public int trap(int[] height){
        int result = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        while(index < height.length){
            while(stack.size() != 0 && height[stack.peek()] < height[index]){
                int curTop = stack.pop();
                if(stack.size() == 0)
                    break;
                int distance = index - stack.peek() - 1;
                int h = Math.min(height[index], height[stack.peek()]) - height[curTop];
                result += distance * h;
            }
            stack.push(index++);
        }
        return result;
    }
}
