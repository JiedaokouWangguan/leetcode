public class Question695{
    
    public int maxAreaOfIsland(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;   
        for(int row = 0;row < rows; row++)
        {
            for(int col = 0;col < cols; col++)
            {
                if(visited[row][col])
                    continue;
                int area = dfs(grid, visited, row, col);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col)
    {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return 0;
        if(visited[row][col] || grid[row][col] == 0)
            return 0;

        visited[row][col] = true;
        int area = 0;
        area += dfs(grid, visited, row-1, col);
        area += dfs(grid, visited, row+1, col);
        area += dfs(grid, visited, row, col-1);
        area += dfs(grid, visited, row, col+1);
        area += 1;
        return area;
    }
}
