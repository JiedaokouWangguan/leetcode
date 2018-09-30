public class Question240{
    // 11.35 - 11.44, 10mins
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;   
        int col = cols-1;
        while(row >= 0 && row < rows && col >= 0 && col < cols){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target){
                col -= 1;
            }             
            else{         
                row += 1;
            }             
        }                 
        return false;  
    } 
}
