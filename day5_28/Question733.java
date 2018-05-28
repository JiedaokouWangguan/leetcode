import java.util.Deque;
import java.util.ArrayDeque;

class Point{
    int row;
    int col;
    Point(int r, int c){
        row = r;
        col = c;
    }
}
public class Question733{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        if(image[sr][sc] == newColor)
            return image;
        ArrayDeque<Point> queue = new ArrayDeque<>();
        Point root = new Point(sr, sc);
        queue.offer(root);
        int color = image[sr][sc];
        while(queue.size() != 0)
        {
            Point p = queue.poll();
            if(image[p.row][p.col] == color)
            {
                visited[p.row][p.col] = true;
                if(p.row > 0)
                    queue.offer(new Point(p.row-1, p.col));
                if(p.row < image.length-1)
                    queue.offer(new Point(p.row+1, p.col));
                if(p.col > 0)
                    queue.offer(new Point(p.row, p.col-1));
                if(p.col < image[0].length-1)
                    queue.offer(new Point(p.row, p.col+1));
            }
        }
        return image;
    }
}
