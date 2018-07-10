import java.util.ArrayList;

public class Question531{
    public int findLonelyPixel(char[][] picture) {
        int rows = picture.length;
        int cols = picture[0].length;
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];
        ArrayList<int[]> pos = new ArrayList<>();
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                if(picture[row][col] == 'B'){
                    pos.add(new int[]{row, col});
                    rowCount[row] += 1;
                    colCount[col] += 1;
                }
            }
        }
        int result = 0;
        for(int[] p : pos){
            int r = p[0];
            int c = p[1];
            if(rowCount[r] == 1 && colCount[c] == 1) result += 1;
        }
        return result;
    }
}
