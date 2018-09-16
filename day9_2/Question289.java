public class Question289{
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] nextBoard = new int[rows][cols];

        int[][] delta = new int[][]{{1, 0}, {1, 1}, {1, -1}, {0, 1}, {0, -1}, {-1, 0}, {-1, 1}, {-1,-1}};
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                int numLive = 0;
                for(int i = 0;i<8;i++){
                    int newRow = row + delta[i][0];
                    int newCol = col + delta[i][1];
                    if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) continue;
                    if(board[newRow][newCol] == 1) numLive += 1;
                }
                if(board[row][col] == 1){
                    if(numLive < 2) nextBoard[row][col] = 0;
                    else if(numLive > 3) nextBoard[row][col] = 1;
                }
                else{
                    if(numLive == 3) nextBoard[row][col] = 1;
                }
            }
        }
        board = nextBoard;
    }
}
