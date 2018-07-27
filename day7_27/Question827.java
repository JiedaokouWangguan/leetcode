import java.util.HashMap;
import java.util.HashSet;

public class Question827{
    int[] delta = new int[]{0, 1, 0, -1, 0};
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int curIndex = 2;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (visited[row][col]) continue;
                if (grid[row][col] == 0) continue;
                int res = dfs(grid, visited, curIndex, row, col);
                map.put(curIndex, res);
                max = Math.max(max, res);
                curIndex += 1;
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != 0) continue;
                HashSet<Integer> tmpSet = new HashSet<Integer>(4);
                for (int i = 0; i < 4; i++) {
                    int newRow = row + delta[i];
                    int newCol = col + delta[i + 1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                            && grid[newRow][newCol] != 0) {
                        int tmpIndex = grid[newRow][newCol];
                        tmpSet.add(tmpIndex);
                            }
                }
                int tmpResult = 0;
                for (int index : tmpSet) {
                    tmpResult += map.get(index);
                }
                tmpResult += 1;
                max = Math.max(max, tmpResult);

            }
        }
        return max;
    }

    private int dfs(int[][] grid, boolean[][] visited, int index, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[row][col] == 0) return 0;
        if (visited[row][col]) return 0;
        int result = 0;
        grid[row][col] = index;
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = row + delta[i];
            int newCol = col + delta[i + 1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                result += dfs(grid, visited, index, newRow, newCol);
            }
        }
        result += 1;
        return result;
    }
}
