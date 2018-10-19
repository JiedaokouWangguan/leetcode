import java.util.HashMap;

public class Question329{
    HashMap<String, Integer> map = new HashMap<>();
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int result = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                int cur = dp(matrix, row, col);
                result = Math.max(result, cur);
            }          
        }              
        return result;
    }                  

    int[][] delta = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int dp(int[][] matrix, int row, int col){
        String key = row + "," + col;
        if(map.containsKey(key)) return map.get(key);                                                                                   
        int max = 1;   
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0;i<4;i++){
            int newRow = row + delta[i][0];
            int newCol = col + delta[i][1];
            if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || matrix[newRow][newCol] <= matrix[row][col])
                continue;
            max = Math.max(max, dp(matrix, newRow, newCol) + 1);
        }              
        map.put(key, max);
        return max;    
    }    
}
