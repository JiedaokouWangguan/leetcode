import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Question835{
    public int largestOverlap(int[][] A, int[][] B) {
        List<int[]> aList = new ArrayList<>();
        List<int[]> bList = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();
        int rows = A.length;
        int cols = A[0].length;
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(A[row][col] == 1) aList.add(new int[]{row, col});
                if(B[row][col] == 1) bList.add(new int[]{row, col});
            }
        }

        for(int[] a : aList){
            for(int[] b : bList){
                int rowDiff = a[0] - b[0];
                int colDiff = a[1] - b[1];
                String key = rowDiff + "," + colDiff;
                count.put(key, count.getOrDefault(key, 0)+1);
            }
        }
        int max = 0;
        for(String key : count.keySet()){
            max = Math.max(max, count.get(key));
        }
        return max;
    }
}
