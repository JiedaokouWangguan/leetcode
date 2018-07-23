import java.util.PriorityQueue;
import java.util.Comparator;

public class Question490{
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] minLen = new int[rows][cols];
        for(int i = 0;i<rows * cols;i++) minLen[i/cols][i%cols] = Integer.MAX_VALUE;
        Point p = new Point(start[0], start[1], 0);
        int[] delta = {0, 1, 0, -1, 0};
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                return p1.len - p2.len;
            }
        });
        pq.offer(p);
        while(pq.size() != 0){
            Point tmp = pq.poll();
            if(tmp.len >= minLen[tmp.row][tmp.col]) continue;
            minLen[tmp.row][tmp.col] = tmp.len;
            for(int i = 0;i<4;i++){
                int newRow = tmp.row;
                int newCol = tmp.col;
                int newLen = tmp.len;
                while(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && maze[newRow][newCol] == 0){
                    newRow += delta[i];
                    newCol += delta[i+1];
                    newLen += 1;
                }
                newRow -= delta[i];
                newCol -= delta[i+1];
                newLen -= 1;
                pq.offer(new Point(newRow, newCol, newLen));
            }
        }
        return minLen[destination[0]][destination[1]] != Integer.MAX_VALUE;
    }
}

class Point{
    int row;
    int col;
    int len;
    public Point(int _row, int _col, int _len){
        row = _row;
        col = _col;
        len = _len;
    }
}
