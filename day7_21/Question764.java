import java.util.Arrays;

public class Question764{
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] matrix = new int[N][N];
        for(int i = 0;i<N;i++) Arrays.fill(matrix[i], N);
        for(int[] mine : mines) matrix[mine[0]][mine[1]] = 0;
        for(int i = 0;i<N;i++){
            for(int j = 0, k = N-1, u = 0, d = 0, l = 0, r = 0;j < N;j++, k--){
                matrix[i][j] = Math.min(matrix[i][j], l = (matrix[i][j] == 0?0:l+1));
                matrix[i][k] = Math.min(matrix[i][k], r = (matrix[i][k] == 0?0:r+1));
                matrix[j][i] = Math.min(matrix[j][i], u = (matrix[j][i] == 0?0:u+1));
                matrix[k][i] = Math.min(matrix[k][i], d = (matrix[k][i] == 0?0:d+1));
            }
        }
        int res = 0;
        for(int row=0;row<N;row++){
            for(int col=0;col<N;col++){
                res = Math.max(res, matrix[row][col]);
            }
        }
        return res;
    }
}
