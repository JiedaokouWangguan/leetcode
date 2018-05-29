public class Question661{
    public int[][] imageSmoother(int[][] M){
        int rows = M.length;
        int cols = M[0].length;
        int[][] result = new int[rows][cols];

        for(int row = 0;row < rows; row++){
            for(int col = 0;col < cols; col++){
                int count = 0;
                int sum = 0;
                if(row>0 && col>0){
                    count += 1;
                    sum += M[row-1][col-1];
                }
                if(row>0){
                    count += 1;
                    sum += M[row-1][col];
                }
                if(row>0 && col < cols-1){
                    count += 1;
                    sum += M[row-1][col+1];
                }
                if(col>0){
                    count += 1;
                    sum += M[row][col-1];
                }
                if(col<cols-1){
                    count += 1;
                    sum += M[row][col+1];
                }
                if(row<rows-1 && col>0){
                    count += 1;
                    sum += M[row+1][col-1];
                }
                if(row<rows-1){
                    count += 1;
                    sum += M[row+1][col];
                }
                if(row<rows-1 && col < cols-1){
                    count += 1;
                    sum += M[row+1][col+1];
                }
                count += 1;
                sum += M[row][col];
                result[row][col] = sum/count;
            }
        }
        return result;
    }
}
