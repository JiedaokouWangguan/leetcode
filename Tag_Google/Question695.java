public class Question695{
    // 6.22 - 6.--
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int row = 0;row<rows;row++){
            for(int col = 0;col < cols;col++){
                if(grid[row][col] == 1 && !visited[row][col])
                    max = Math.max(max, helper(grid, row, col, visited));
            }
        }
        return max;
    }

    int[][] delta = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int helper(int[][] grid, int row, int col, boolean[][] visited){
        visited[row][col] = true;
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 1;
        for(int i = 0;i<4;i++){
            int newRow = row + delta[i][0];
            int newCol = col + delta[i][1];
            if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol] && grid[newRow][newCol] == 1){
                result += helper(grid, newRow, newCol, visited);
            }
        }
        return result;
    }
}
