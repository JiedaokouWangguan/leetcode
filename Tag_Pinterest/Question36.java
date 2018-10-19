import java.util.HashMap;
import java.util.HashSet;

public class Question36{
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<Integer, HashSet<Character>> boxes = new HashMap<>();
        for(int i = 0;i<9;i++){
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            boxes.put(i, new HashSet<>());
        }
        for(int row = 0;row < 9;row++){
            for(int col = 0;col < 9;col++){
                char curChar = board[row][col];
                if(curChar == '.') continue;
                if(rows.get(row).contains(curChar)) return false;
                if(cols.get(col).contains(curChar)) return false;
                if(boxes.get(3 * (row/3) + (col/3)).contains(curChar)) return false;
                rows.get(row).add(curChar);
                cols.get(col).add(curChar);
                boxes.get(3 * (row/3) + (col/3)).add(curChar);
            }
        }
        return true;
    }
}
