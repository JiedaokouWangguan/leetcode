package leetcode.day8_28;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Song on 2018/9/2.
 */

public class Question446 {
    public int numberOfArithmeticSlices(int[] A) {
        HashMap<Integer, HashMap<Long, Integer>> map = new HashMap<>();
        int result = 0;
        int n = A.length;
        for (int i = 0;i<n;i++) map.put(i, new HashMap<>());
        for (int j = 1;j<n;j++){
            for (int i = 0;i<j;i++){
                long diff = (long)A[j] - (long)A[i];
                int count = map.get(i).getOrDefault(diff, 0);
                result += count;
                map.get(j).put(diff, count + map.get(j).getOrDefault(diff, 0) + 1);
            }
        }
        return result;
    }
}
