public class Question289{
    public void gameOfLife(int[][] board) {
        // 0 is dead in this round, keep dead in the next round
        // 1 is alive in this round, keep alive in the next round
        // 2 is dead this round, will be alive in the next round
        // 3 is alive in this round, will be dead in the next round
        int rows = board.length;
        int cols = board[0].length;
        int[][] delta = new int[][]{{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                int count = 0;
                for(int i=0;i<8;i++){
                    int newRow = row + delta[i][0];
                    int newCol = col + delta[i][1];
                    if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) continue;
                    if(board[newRow][newCol] == 1 || board[newRow][newCol] == 3) count += 1;
                }
                if(board[row][col] == 0){
                    board[row][col] = count == 3?2:0;
                }
                else{
                    if(count < 2) board[row][col] = 3;
                    else if(count > 3) board[row][col] = 3;
                }
            }
        }
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                if(board[row][col] == 0 || board[row][col] == 3) board[row][col] = 0;
                else board[row][col] = 1;
            }
        }
    }
}
