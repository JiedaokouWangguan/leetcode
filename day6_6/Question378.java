public class Question378{
    public int kthSmallest(int[][] matrix, int k){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = k / cols;
        int col = k % cols;
        return matrix[row][col];
    }
}
