import java.util.ArrayDeque;

public class Question542{
    public int[][] updateMatrix(int[][] matrix) {
        ArrayDeque<Position> queue = new ArrayDeque<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                if(matrix[row][col] == 0)
                    queue.offer(new Position(row, col));
                else
                    matrix[row][col] = Integer.MAX_VALUE;
            }
        }
        int[] delta = {0, 1, 0, -1, 0};
        while(queue.size() != 0){
            Position p = queue.poll();
            for(int i = 0;i<4;i++){
                int newRow = p.row+delta[i];
                int newCol = p.col+delta[i+1];
                if(newRow >=0 && newRow<rows && newCol>=0 && newCol<cols){
                    if(matrix[newRow][newCol] == 0)
                        continue;
                    if(matrix[newRow][newCol] > matrix[p.row][p.col] + 1 ){
                        matrix[newRow][newCol] = 1 + matrix[p.row][p.col];
                        queue.offer(new Position(newRow, newCol));
                    }
                }
            }
        }
        return matrix;
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
