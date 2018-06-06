public class Question529{
    public char[][] updateBoard(char[][] board, int[] click){
        int clickRow = click[0];
        int clickCol = click[1];
        boolean[][] visited = new boolean[board.length][board[0].length];
        dfs(board, visited, clickRow, clickCol);
        return board;
    }

    private void dfs(char[][] board, boolean[][] visited, int row, int col){
        if(visited[row][col])
            return;
        visited[row][col] = true;
        if(board[row][col] == 'M')
        {
            board[row][col] = 'X';
        }
        else if(board[row][col] == 'E'){
            int result = 0;
            for(int i = row-1;i <=row+1;i++){
                for(int j = col-1;j<=col+1;j++){
                    if(i >= 0 && i <board.length && j>=0 && j<board[0].length){
                        if(board[i][j] == 'M' || board[i][j] == 'X')
                            result += 1;
                    }
                }
            }
            if(result == 0){
                for(int i = row-1;i <=row+1;i++){
                    for(int j = col-1;j<=col+1;j++){
                        if(i >= 0 && i <board.length && j>=0 && j<board[0].length){
                            dfs(board, visited, i, j);
                        }
                    }
                }
                board[row][col] = 'B';
            }
            else{
                board[row][col] = (char)(result+'0');
            }
        }
    }
}
