public class Question240_1{
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0)
            return false;
        int curRow = 0;
        int curCol = matrix[0].length-1;
        while(curRow < matrix.length && curCol >= 0){
            int tmp = matrix[curRow][curCol];
            if(tmp == target)
                return true;
            else if(target < tmp)
                curCol -= 1;
            else
                curRow += 1;
        }
        return false;
    }
}
