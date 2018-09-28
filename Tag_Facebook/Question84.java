import java.util.ArrayDeque;

public class Question84{
    // 11.47-11.58
    public int largestRectangleArea(int[] heights) {
        int[] heightsP = new int[heights.length+2];       
        heightsP[0] = 0;             
        heightsP[heightsP.length-1] = 0;
        for(int i = 0;i<heights.length;i++) heightsP[i+1] = heights[i];
        ArrayDeque<Integer> stack = new ArrayDeque<>();   
        int result = 0;               
        for(int i = 0;i<heightsP.length;i++){
            while(stack.size()>0 && heightsP[i] < heightsP[stack.peek()]){
                int tmpMidIndex = stack.pop();
                int left = stack.size() >0?stack.peek():-1;
                int right = i;       
                int width = right - left - 1;
                int height = heightsP[tmpMidIndex];
                result = Math.max(result, height * width);                                                       
            }                        
            stack.push(i);           
        }                            
        return result;   
    }
}
}
