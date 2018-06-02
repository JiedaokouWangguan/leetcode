public class Question498{
    public int[] findDiagonalOrder(int[][] matrix){
        int curRow = 0;
        int curCol = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int n = row * col;
        int[] result = new int[n];
        boolean isGoingUp = true;
        for(int index = 0;index<n;index++){
            result[index] = matrix[curRow][curCol];
            if(isGoingUp){
                if(curRow-1 <0 || curRow-1 >= row || curCol+1 <0 || curCol+1 >= col){
                    if(curCol + 1 < col){
                        curCol = curCol + 1;
                    }
                    else{
                        curRow = curRow+1;
                    }
                    isGoingUp = !isGoingUp;
                }
                else{
                    curCol = curCol+1;
                    curRow = curRow-1;
                }
            }
            else{
                if(curRow+1 <0 || curRow+1 >= row || curCol-1 <0 || curCol-1 >= col){
                    if(curRow + 1 < row){
                        curRow = curRow + 1;
                    }
                    else{
                        curCol = curCol+1;
                    }
                    isGoingUp = !isGoingUp;
                }
                else{
                    curCol = curCol-1;
                    curRow = curRow+1;
                }
            }
        }
        return result;
    }
}
