import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Question417{
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new ArrayList<int[]>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] leftTop = new boolean[rows][cols];
        boolean[][] rightDown = new boolean[rows][cols];
        
        ArrayDeque<int[]> queueLeftTop = new ArrayDeque<>();
        ArrayDeque<int[]> queueRightDown = new ArrayDeque<>();

        for(int row = 0;row < rows;row++){
            queueLeftTop.offer(new int[]{row, 0});
            queueRightDown.offer(new int[]{row, cols-1});
        }
        for(int col = 0;col < cols;col++){
            queueLeftTop.offer(new int[]{0, col});
            queueRightDown.offer(new int[]{rows-1, col});
        }
        bfs(queueLeftTop, leftTop, matrix);
        bfs(queueRightDown, rightDown, matrix);

        List<int[]> result = new ArrayList<>();
        for(int row = 0;row<rows;row++){
            for(int col = 0;col < cols;col++){
                if(leftTop[row][col] && rightDown[row][col])
                    result.add(new int[]{row, col});
            }
        }
        return result;
    }

    private void bfs(ArrayDeque<int[]> queue, boolean[][] visited, int[][] matrix){
        int[] delta = {0, 1, 0, -1, 0};
        int rows = visited.length;
        int cols = visited[0].length;
        while(queue.size() != 0){
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            visited[curRow][curCol] = true;
            for(int i = 0;i<4;i++){
                int newRow = curRow + delta[i];
                int newCol = curCol + delta[i+1];
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol] && matrix[curRow][curCol] <= matrix[newRow][newCol])
                    queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}
