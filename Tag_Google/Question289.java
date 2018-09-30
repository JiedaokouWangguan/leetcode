public class Question289{
    // 8.29 - 8.45, 16mins
    int[][] delta = new int[][]{{0, 1}, {1, 0}, {1, 1}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}};
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int row = 0;row<rows;row++){
            for(int col = 0;col < cols;col++){
                int numLives = 0;
                for(int i = 0;i<8;i++){
                    // 0 - dead now, dead next
                    // 1 - live now, live next
                    // 2 - dead now, live next
                    // 3 - live now, dead next
                    int newRow = row + delta[i][0];
                    int newCol = col + delta[i][1];
                    if(newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols) continue;
                    int curNum = board[newRow][newCol];
                    if(curNum == 1 || curNum == 3) numLives += 1;
                }
                if(board[row][col] == 0){
                    if(numLives == 3) board[row][col] = 2;
                }
                else{
                    if(numLives < 2 || numLives > 3) board[row][col] = 3;
                }
            }
        }
        for(int row = 0;row<rows;row++){
            for(int col = 0;col < cols;col++){
                if(board[row][col] == 2) board[row][col] = 1;
                else if(board[row][col] == 3) board[row][col] = 0;
            }
        }
    }
}
