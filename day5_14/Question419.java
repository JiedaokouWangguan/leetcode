package leetcode.day5_14;

public class Question419
{
    public int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0;i<board.length;i++)
            for (int j = 0;j<board[i].length;j++)
                if (board[i][j] == 'X')
                    if(!(i > 0 && board[i-1][j] == 'X') && !(j > 0 && board[i][j-1] == 'X'))
                        result += 1;
        return result;
    }
}
