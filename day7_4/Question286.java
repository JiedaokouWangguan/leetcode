import java.util.ArrayDeque;

public class Question286{
    public void wallsAndGates(int[][] rooms) {
        ArrayDeque<Position> queue = new ArrayDeque<>();
        for(int i = 0;i<rooms.length;i++){
            for(int j = 0;j<rooms[0].length;j++){
                if(rooms[i][j] == 0)
                    queue.offer(new Position(i, j));
            }
        }
        
        int dist = 1;
        while(queue.size() != 0){
            int len = queue.size();
            for(int i = 0;i<len;i++){
                Position tmp = queue.poll();
                if(tmp.row != 0 && rooms[tmp.row-1][tmp.col] == Integer.MAX_VALUE){
                    rooms[tmp.row-1][tmp.col] = dist;
                    queue.offer(new Position(tmp.row-1, tmp.col));
                }
                if(tmp.row != rooms.length-1 && rooms[tmp.row+1][tmp.col] == Integer.MAX_VALUE){
                    rooms[tmp.row+1][tmp.col] = dist;
                    queue.offer(new Position(tmp.row+1, tmp.col));
                }             
                if(tmp.col != 0 && rooms[tmp.row][tmp.col-1] == Integer.MAX_VALUE){
                    rooms[tmp.row][tmp.col-1] = dist;
                    queue.offer(new Position(tmp.row, tmp.col-1));
                }
                if(tmp.col != rooms[0].length-1 && rooms[tmp.row][tmp.col+1] == Integer.MAX_VALUE){
                    rooms[tmp.row][tmp.col+1] = dist;
                    queue.offer(new Position(tmp.row, tmp.col+1));
                }
            }
            dist += 1;
        }
    }
}

class Position{
    int row;
    int col;
    public Position(int a, int b){
        row = a;
        col = b;
    }
}
