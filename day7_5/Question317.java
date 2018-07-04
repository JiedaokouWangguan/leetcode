import java.util.ArrayDeque;
import java.util.ArrayList;

public class Question317{
    public int shortestDistance(int[][] grid) {
        int numBuilding = 0;
        ArrayList<ArrayDeque<Position>> list = new ArrayList<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    ArrayDeque<Position> queue = new ArrayDeque<>();
                    numBuilding += 1;
                    queue.offer(new Position(i, j));
                    list.add(queue);
                }
            }
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] visited = new int[rows][cols][numBuilding];
        for(int i = 0;i<rows;i++)
            for(int j = 0;j<cols;j++)
                for(int k = 0;k<numBuilding;k++)
                    visited[i][j][k] = -1;
        boolean tag = true;
        int step = 0;
        while(tag){
            tag = false;
            for(int i = 0;i<numBuilding;i++){
                if(list.get(i).size() != 0){
                    tag = true;
                    ArrayDeque<Position> tmpQueue = list.get(i);
                    int len = tmpQueue.size();
                    for(int j = 0;j<len;j++){
                        Position p = tmpQueue.poll();
                        visited[p.row][p.col][i] = step;
                        int sum = 0;
                        for(int k = 0;k<numBuilding;k++){
                            sum += visited[p.row][p.col][i];
                            if(visited[p.row][p.col][i] == -1){
                                sum = -1;
                                break;
                            }
                        }
                        if(sum != -1)
                            return sum;
                        if(p.row != 0 && visited[p.row-1][p.col][i] == -1)
                            tmpQueue.offer(new Position(p.row-1, p.col));
                        if(p.row != rows-1 && visited[p.row+1][p.col][i] == -1)
                            tmpQueue.offer(new Position(p.row+1, p.col));
                        if(p.col != 0 && visited[p.row][p.col-1][i] == -1)
                            tmpQueue.offer(new Position(p.row, p.col-1));
                        if(p.col != cols-1 && visited[p.row][p.col+1][i] == -1)
                            tmpQueue.offer(new Position(p.row, p.col+1));
                    }
                }
            }
            step += 1;
        }
        return -1;
    }
}

class Position{
    int row;
    int col;
    public Position(int i, int j){
        row = i;
        col = j;
    }
}
