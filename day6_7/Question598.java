public class Question598{
    public int maxCount(int m, int n, int[][] ops){
        int rows = m;
        int cols = n;
        for(int[] op : ops){
            rows = Math.min(rows, op[0]);
            cols = Math.min(cols, op[1]);
        }
        return rows * cols;
    }
}
