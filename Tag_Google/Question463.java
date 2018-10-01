public class Question463{
    // 2.50 - 2.55, 6mins
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] delta = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int result = 0;
        for(int row = 0;row<rows;row++){
            for(int col = 0;col < cols;col++){
                if(grid[row][col] == 0) continue;
                int numLand = 0;
                for(int i = 0;i<4;i++){
                    int newRow = row + delta[i][0];
                    int newCol = col + delta[i][1];
                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1)
                        numLand += 1;
                }
                result += (4-numLand);
            }
        }
        return result;
    }
}
