import java.util.PriorityQueue;
import java.util.Comparator;

public class Question778{
    public int swimInWater(int[][] grid) {
        PriorityQueue<Position> pq = new PriorityQueue<>(new Comparator<Position>(){
            @Override
            public int compare(Position p1, Position p2){
                return p1.val - p2.val;
            }
        });
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int curHeight = grid[0][0];
        pq.offer(new Position(0, 0, grid[0][0]));
        while(pq.size() != 0){
            Position curPosition = pq.poll();
            if(visited[curPosition.row][curPosition.col])
                continue;
            visited[curPosition.row][curPosition.col] = true;
            curHeight = Math.max(curHeight, curPosition.val);
            if(curPosition.row == grid.length-1 && curPosition.col == grid.length-1)
                return curHeight;
            if(curPosition.row != 0)
                pq.offer(new Position(curPosition.row-1, curPosition.col, grid[curPosition.row-1][curPosition.col]));
            if(curPosition.row != grid.length-1)
                pq.offer(new Position(curPosition.row+1, curPosition.col, grid[curPosition.row+1][curPosition.col]));
            if(curPosition.col != 0)
                pq.offer(new Position(curPosition.row, curPosition.col-1, grid[curPosition.row][curPosition.col-1]));
            if(curPosition.col != grid.length-1)
                pq.offer(new Position(curPosition.row, curPosition.col+1, grid[curPosition.row][curPosition.col+1]));
        }
        return curHeight;
    }
}

class Position{
    int row;
    int col;
    int val;
    Position(int r, int c, int v){
        row = r;
        col = c;
        val = v;
    }
}
