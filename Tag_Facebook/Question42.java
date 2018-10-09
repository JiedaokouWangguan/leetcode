import java.util.ArrayDeque;

public class Question42{
    public int trap(int[] height){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for(int i = 0;i<height.length;i++){
            while(stack.size() > 0 && height[stack.peek()] <= height[i]){
                int mid = stack.pop();
                if(stack.size() == 0) break;
                int left = stack.peek();
                result += (i - left - 1) * (Math.min(height[left], height[i]) - height[mid]);
            }
            stack.push(i);
        }
        return result;
    }    
}
