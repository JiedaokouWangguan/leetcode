import java.util.HashSet;

public class Question874{
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> set = new HashSet<>();
        for (int[] ob : obstacles)
            set.add(ob[0] + "," + ob[1]);
        int row = 0;
        int col = 0;
        int max = 0;
        int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int N = 0;
        int E = 1;
        int S = 2;
        int W = 3;
        int cur = N;
        for (int c : commands) {
            if (c == -1) cur = (cur + 1) % 4;
            else if (c == -2) cur = (cur - 1 + 4) % 4;
            else {
                for (int i = 0; i < c; i++) {
                    int newRow = row + delta[cur][0];
                    int newCol = col + delta[cur][1];
                    if (set.contains(newRow + "," + newCol)) break;
                    row = newRow;
                    col = newCol;
                }
                max = Math.max(max, getSquare(row, col));
            }
        }
        return max;
    }

    private int getSquare(int row, int col) {
        return row * row + col * col;
    }
}
