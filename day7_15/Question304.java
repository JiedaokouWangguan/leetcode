class NumMatrix {

    int[][] sum = null;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        sum = new int[rows][cols];
        
        sum[0][0] = matrix[0][0];
        for(int row = 1;row<rows;row++)
            sum[row][0] = sum[row-1][0] + matrix[row][0]; 
        for(int col = 1;col<cols;col++)
            sum[0][col] = sum[0][col-1] + matrix[0][col];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0)
            return sum[row2][col2];
        else if(col1 == 0)
            return sum[row2][col2] - sum[row1-1][col2];
        else if(row1 == 0)
            return sum[row2][col2] - sum[row2][col1-1];
        return sum[row2][col2] + sum[row1-1][col1-1] - sum[row1-1][col2] - sum[row2][col1-1];
    }
}

