public class Question803{
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int[] i : hits){
            int row = i[0];
            int col = i[1];
            if(grid[row][col] == 0) continue;
            else grid[row][col] = -1;
        }

        for(int col = 0;col<cols;col++){
            dfs(grid, 0, col);
        }

        int[] result = new int[hits.length];
        for(int i = hits.length-1;i>=0;i--){
            int row = hits[i][0];
            int col = hits[i][1];
            if(grid[row][col] == 0) continue;
            boolean tag = row == 0;
            for(int j = 0;j<4 && !tag;j++){
                int newRow = row + delta[j][0];
                int newCol = col + delta[j][1];
                if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) continue;
                if(grid[newRow][newCol] == 2) tag = true;
            }
            int count = 0;
            if(!tag){
                grid[row][col] = 1;
            }
            else{
                grid[row][col] = 2;
                for(int j = 0;j<4;j++){
                    int newRow = row + delta[j][0];
                    int newCol = col + delta[j][1];
                    if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) continue;
                    count += dfs(grid, newRow, newCol);
                }
            }
            result[i] = count;
        }
        return result;
    }        

    int[][] delta = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int dfs(int[][] grid, int row, int col){
        if(grid[row][col] != 1) return 0;
        int result = 1;
        grid[row][col] = 2;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0;i<4;i++){
            int newRow = row + delta[i][0];
            int newCol = col + delta[i][1];
            if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) continue;
            result += dfs(grid, newRow, newCol);
        }   
        return result;
    }
}
