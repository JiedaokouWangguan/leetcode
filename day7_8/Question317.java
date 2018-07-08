import java.util.ArrayDeque;

public class Question317{
    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = -1;
        int walk = 0;
        int[][] dist = new int[rows][cols];
        int[][] visited = new int[rows][cols];
        int[] delta = { 0, 1, 0, -1, 0 };
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    int[][] curDist = new int[rows][cols];
                    result = -1;
                    ArrayDeque<Position> queue = new ArrayDeque<>();
                    queue.offer(new Position(row, col));
                    while (queue.size() != 0) {
                        Position p = queue.poll();
                        for (int j = 0; j < 4; j++) {
                            int newRow = p.row + delta[j];
                            int newCol = p.col + delta[j + 1];
                            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                                    && grid[newRow][newCol] == 0
                                    && visited[newRow][newCol] == walk) {
                                visited[newRow][newCol] -= 1;
                                curDist[newRow][newCol] = curDist[p.row][p.col] + 1;
                                dist[newRow][newCol] += curDist[newRow][newCol];
                                queue.offer(new Position(newRow, newCol));
                                if (result < 0 || result > dist[newRow][newCol])
                                    result = dist[newRow][newCol];
                                    }
                        }
                    }
                    walk -= 1;
                }
                int sdf = 1;
            }
        }
        return result;
    }
}

class Position{
    int row;
    int col;
    public Position(int x, int y){
        row = x;
        col = y;
    }
}
