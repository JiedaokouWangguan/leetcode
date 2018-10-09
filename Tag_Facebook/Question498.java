
public class Question498{
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0];
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int dir = 1;
        int row = 0;
        int col = 0;
        int newRow = 0;
        int newCol = 0;
        for(int i = 0;i<rows*cols;i++){
            result[i] = matrix[row][col];
            if(dir == 1){ 
                newRow = row - 1;
                newCol = col + 1;
                if(!isValid(newRow, newCol, rows, cols)){
                    dir = -1; 
                    if(newCol < cols) newRow += 1;
                    else{
                        newRow += 2;
                        newCol -= 1;
                    }   
                }   
            }       
            else{
                newRow = row + 1;                                                                                                             
                newCol = col - 1;
                if(!isValid(newRow, newCol, rows, cols)){
                    dir = 1;
                    if(newRow < rows) newCol += 1;
                    else{
                        newCol += 2;
                        newRow -= 1;
                    }   
                }   

            }       
            row = newRow;
            col = newCol;
        }           
        return result;
    }
    private boolean isValid(int row, int col, int rows, int cols){
        return row >= 0 && row < rows && col>= 0 && col < cols;
    }
}
