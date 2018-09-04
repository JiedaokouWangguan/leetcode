package leetcode.day8_29;

import java.util.Arrays;

public class Question899 {
    public String orderlyQueue(String S, int K) {
        if (K > 1){
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        String res = S;
        for (int i = 0;i<S.length();i++){
            String tmp = S.substring(i) + S.substring(0, i);
            if (tmp.compareTo(res) < 0 ) res = tmp;
        }
        return res;
    }
}
