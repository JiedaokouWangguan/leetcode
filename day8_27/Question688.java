package leetcode.day8_27;

import java.util.HashMap;

/**
 * Created by Song on 2018/9/1.
 */
public class Question688 {
    HashMap<String, Double> map = new HashMap<>();
    int[][] delta = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
    public double knightProbability(int N, int K, int r, int c) {
        return helper(N, K, r, c, 1.0);
    }
    private double helper(int n, int k, int r, int c, double curPro){
        if (k == 0) return curPro;
        String key = k + "," + r + "," + c;
        if(map.containsKey(key)) return map.get(key);
        double res = 0;
        double newPro = curPro/8;
        for(int i = 0;i<8;i++){
            int newRow = r + delta[i][0];
            int newCol = c + delta[i][1];
            if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) continue;
            res += helper(n, k-1, newRow, newCol, newPro);
        }
        map.put(key, res);
        return res;
    }
}
