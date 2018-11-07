import java.util.ArrayDeque;

public class Question739{
    // 11.18 - 11.22, 5mins
    /*
       public int[] dailyTemperatures(int[] temperatures) {
       ArrayDeque<Integer> stack = new ArrayDeque<>();
       int n = temperatures.length;
       int[] result = new int[n];
       for(int i = 0;i<n;i++){
       int curTemp = temperatures[i];
       while(stack.size() > 0 && curTemp > temperatures[stack.peek()]){
       int tmpIndex = stack.pop();
       result[tmpIndex] = i - tmpIndex;
       }
       stack.push(i);
       }
       while(stack.size() > 0){
       result[stack.pop()] = 0;
       }
       return result;
       }
       */
    public int[] dailyTemperatures(int[] T) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int curIdx = T.length-1;
        int[] result = new int[T.length];
        while(curIdx >= 0){
            int curTemp = T[curIdx];
            while(stack.size() > 0 && curTemp >= T[stack.peek()]){
                stack.pop();
            }
            if(stack.size() == 0) result[curIdx] = 0;
            else result[curIdx] = stack.peek() - curIdx;
            stack.push(curIdx);
            curIdx -= 1;
        }
        return result;
    }   
}
