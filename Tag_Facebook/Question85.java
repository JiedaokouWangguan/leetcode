import java.util.ArrayDeque;

public class Question85{
    // 12.01-12.15
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[cols];
        int result = 0;
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                height[col] = matrix[row][col] == '1'?height[col]+1:0;
            }
            result = Math.max(result, getMax(height));
        }
        return result;
    }

    private int getMax(int[] height){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        int[] newHeight = new int[height.length+2];
        newHeight[0] = 0;
        newHeight[newHeight.length-1] = 0;
        for(int i = 0;i<height.length;i++){
            newHeight[i+1] = height[i];
        }
        for(int i = 0;i<newHeight.length;i++){
            while(stack.size()>0 && newHeight[i] < newHeight[stack.peek()]){
                int minHeight = newHeight[stack.pop()];
                int left = stack.peek();
                int right = i;
                int width = right - left - 1;
                int area = minHeight * width;
                result = Math.max(result, area);
            }
            stack.push(i);
        }
        return result;
    }
}
