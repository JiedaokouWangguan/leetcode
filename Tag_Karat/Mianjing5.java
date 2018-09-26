import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

//9.50-10.22
// the time complexity is O(mn), space complexity is O(nm)
// 找长方形，第一题简单，直接秒，就是On*n的矩阵遍历，注意取长方形左上右下两点的时候有trick，就是用一个四值数组存四个值，每个位置更新一波
// 第二题也简单，也是便利解决，时间还是On*n，空间是Om m是长方形的数量
// 第三题稍微难一点，就像lt里岛屿数量题，时间是On*n遍历+mklogk m个岛屿每个岛屿平均k的长度，空间是mk
public class Mianjing5{
    public List<Integer> findRectangle(int[][] matrix){
        int[] cordi = new int[4];
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int row = 0;row < rows;row++){
            for(int col = 0;col<cols;col++){
                if(matrix[row][col] == 0){
                    cordi[0] = Math.min(cordi[0], row);
                    cordi[2] = Math.max(cordi[2], row);
                    cordi[1] = Math.min(cordi[1], col);
                    cordi[3] = Math.max(cordi[3], col);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i : cordi) list.add(i);
        return list;
    }

    //9.57
    
    //10.00
    
    public List<List<Integer>> getRectangles(int[][] matrix){
        List<List<Integer>> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                if(matrix[row][col] == 0 && !visited[row][col]){
                    int[] cordi = new int[]{row, col, row, col};
                    getRec(row, col, matrix, visited, cordi);
                    List<Integer> tmpResult = new ArrayList<>();
                    for(int num : cordi) tmpResult.add(num);
                    result.add(tmpResult);
                }
            }
        }
        return result;
    }
    int[][] delta = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    private void getRec(int row, int col, int[][] matrix, boolean[][] visited, int[] cordi){
        if(visited[row][col] || matrix[row][col] == 1) return;
        visited[row][col] = true;
        cordi[0] = Math.min(cordi[0], row);
        cordi[2] = Math.max(cordi[2], row);
        cordi[1] = Math.min(cordi[1], col);
        cordi[3] = Math.max(cordi[3], col);
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0;i<4;i++){
            int newRow = row + delta[i][0];
            int newCol = col + delta[i][0];
            if(newRow < 0 || newRow >= rows || newCol < 0 || newCol>= cols || visited[newRow][newCol]) continue;
            getRec(newRow, newCol, matrix, visited, cordi);
        }
    }

    // 10.6
    
    public List<List<int[]>> getGraph(int[][] matrix){
        List<List<int[]>> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        HashSet<String> set = new HashSet<>();
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                if(matrix[row][col] == 1 || visited[row][col]) continue;
                List<int[]> tmpResult = new ArrayList<>();
                getG(row, col, matrix, visited, tmpResult);
                String key = getKey(tmpResult);
                if(set.contains(key)) continue;
                set.add(key);
                result.add(tmpResult);
            }
        }
        return result;
    }

    private String getKey(List<int[]> tmpResult){
        Collections.sort(tmpResult, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                if(i1[0] == i2[0]) return i1[1] - i2[1];
                else return i1[0] - i2[0];
            }
        });
        StringBuilder sb = new StringBuilder();
        int rowBase = tmpResult.get(0)[0];
        int colBase = tmpResult.get(0)[1];
        for(int[] i : tmpResult){
            sb.append(i[0] - rowBase);
            sb.append(",");
            sb.append(i[1] - colBase);
            sb.append(".");
        }
        return sb.toString();
    }


    private void getG(int row, int col, int[][] matrix, boolean[][] visited, List<int[]> tmpResult){
        if(visited[row][col] || matrix[row][col] == 1) return;
        visited[row][col] = true;
        tmpResult.add(new int[]{row, col});
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0;i<4;i++){
            int newRow = row + delta[i][0];
            int newCol = col + delta[i][1];
            if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= col) continue;
            getG(newRow, newCol, matrix, visited, tmpResult);
        }
    }
}
