import java.util.ArrayDeque;

public class Question42{
    // 11.42 - 11.46
    public int ezTrap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        int curMax = 0;
        for(int i = 0;i<height.length;i++){
            curMax = Math.max(curMax, height[i]);
            left[i] = curMax - height[i];
        }
        curMax = 0;
        for(int i = height.length-1;i>=0;i--){
            curMax = Math.max(curMax, height[i]);
            right[i] = curMax - height[i];
        }
        int result = 0;
        for(int i = 0;i<left.length;i++){
            result += Math.min(left[i], right[i]);
        }
        return result;
    }

    // 11.52 - 12.02
    public int trap(int[] height){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for(int i = 0;i<height.length;i++){
            int h = height[i];
            while(stack.size() > 0 && height[stack.peek()] <= h){
                int midHeight = height[stack.pop()];
                if(stack.size() == 0) break;
                int lastIndex = stack.peek();
                result += (i - lastIndex - 1) * (Math.min(h, height[lastIndex]) - midHeight);
            }
            stack.push(i);
        }
        return result;
    }
}
