import java.util.HashMap;

public class Question750{    
    // 3.08 - 3.16, 9mins
    public int countCornerRectangles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        HashMap<String, Integer> map = new HashMap<>();
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                if(grid[row][col] == 0) continue;
                for(int col1 = col+1;col1<cols;col1++){
                    if(grid[row][col1] == 0) continue;
                    String key = col + "," + col1;
                    map.put(key, map.getOrDefault(key, 0)+1);
                }
            }
        }
        int result = 0;
        for(String key : map.keySet()){
            int n = map.get(key);
            result += cal(n);
        }
        return result;
    }

    private int cal(int n){
       return n * (n-1) / 2;
    }
}
