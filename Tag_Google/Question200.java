public class Question200{
    // 11.17 - 11.24, 8mins
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int result = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == '1' && !visited[row][col]){
                    result += 1;
                    dfs(grid, visited, row, col);
                }
            }
        }
        return result;
    }
    
    int[][] delta = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private void dfs(char[][] grid, boolean[][] visited, int row, int col){
        visited[row][col] = true;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0;i<4;i++){
            int newRow = row + delta[i][0];
            int newCol = col + delta[i][1];
            if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || visited[newRow][newCol] || grid[newRow][newCol] == '0') continue;
            dfs(grid, visited, newRow, newCol);
        }
    }
}
