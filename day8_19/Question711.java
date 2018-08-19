import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

public class Question711{
    int[][] delta1 = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] delta2 = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    public int numDistinctIslands2(int[][] a) {
        HashSet<String> result = new HashSet<>();
        int rows = a.length;
        int cols = a[0].length;
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if (a[row][col] == 1) {
                    List<int[]> res = new LinkedList<>();
                    dfs(a, row, col, res);
                    result.add(normalize(res));
                }
        return result.size();
    }

    private void dfs(int[][] a, int row, int col, List<int[]> res) {
        int rows = a.length;
        int cols = a[0].length;
        if (row < 0 || col < 0 || row >= rows || col >= cols || a[row][col] != 1) return;
        res.add(new int[] { row, col });
        a[row][col] = -1;
        for (int i = 0; i < 4; i++) {
            int newRow = row + delta1[i][0];
            int newCol = col + delta1[i][1];
            dfs(a, newRow, newCol, res);
        }
    }

    private String normalize(List<int[]> pos) {
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < 4; i++) {
            List<int[]> list1 = new ArrayList<>();
            List<int[]> list2 = new ArrayList<>();

            for (int[] list : pos) {
                list1.add(new int[] { list[0] * delta2[i][0], list[1] * delta2[i][1] });
                list2.add(new int[] { list[1] * delta2[i][0], list[0] * delta2[i][1] });
            }
            for (List<int[]> curList : Arrays.asList(list1, list2)) {
                Collections.sort(curList, new Comparator<int[]>() {

                    @Override
                    public int compare(int[] i1, int[] i2) {
                        if (i1[0] == i2[0]) return i1[1] - i2[1];
                        else return i1[0] - i2[0];
                    }
                });
                StringBuilder sb = new StringBuilder();
                int tmpRow = curList.get(0)[0];
                int tmpCol = curList.get(0)[1];
                for (int[] tmp : curList) {
                    sb.append(tmp[0] - tmpRow);
                    sb.append(":");
                    sb.append(tmp[1] - tmpCol);
                    sb.append(":");
                }
                set.add(sb.toString());
            }
        }
        return set.first();
    }
}
