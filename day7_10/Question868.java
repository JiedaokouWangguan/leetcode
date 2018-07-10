public class Question868{
    public int[][] transpose(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[cols][rows];
        for(int row = 0;row < rows; row++){
            for(int col = 0;col < cols; col++){
                result[col][row] = A[row][col];
            }
        }
        return result;
    }
}
