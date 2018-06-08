public class Question240{
    public boolean searchMatrix(int[][] matrix, int target){
        return binarySearch(matrix, target, 0, 0, matrix.length-1, matrix[0].length-1);
    }

    private boolean binarySearch(int[][] matrix, int target, int ltRow, int ltCol, int brRow, int brCol){
        if(ltRow > brRow || ltCol > brCol)
            return false;
        
        if(ltRow == brRow && ltCol == brCol)
            return matrix[ltRow][ltCol] == target;

        int midRow = (ltRow + brRow)/2;
        int midCol = (ltCol + brCol)/2;
        int tmp = matrix[midRow][midCol];
        if(tmp == target){
            return true;
        }
        else if(tmp > target){
            if(binarySearch(matrix, target, ltRow, ltCol, midRow-1, midCol-1))
                return true;
            if(binarySearch(matrix, target, midRow, ltCol, brRow, midCol-1))
                return true;
            if(binarySearch(matrix, target, ltRow, midCol, midRow-1, brCol))
                return true;
            return false;
        }
        else{       
            if(binarySearch(matrix, target, midRow+1, midCol+1, brRow, brCol))
                return true;
            if(binarySearch(matrix, target, midRow+1, ltCol, brRow, midCol))
                return true;
            if(binarySearch(matrix, target, ltRow, midCol+1, midRow, brCol))
                return true;
            return false;
        }
    }
}
