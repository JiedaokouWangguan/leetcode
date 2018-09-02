package leetcode.day8_28;

import java.util.HashSet;

/**
 * Created by Song on 2018/9/2.
 */
public class Question898 {
    public int subarrayBitwiseORs(int[] A) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> cur = new HashSet<>();
        HashSet<Integer> cur1 = null;
        for(int i : A){
            cur1 = new HashSet<>();
            cur1.add(i);
            for (int j : cur) cur1.add(j | i);
            cur = cur1;
            for (int j : cur) res.add(j);
        }
        return res.size();
    }
}
