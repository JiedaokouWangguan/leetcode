package leetcode.day5_20;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Song on 2018/5/20.
 */
public class Question791
{
    public String customSortString(String S, String T) {
        int[] order = new int[26];
        for (int i = 0;i<S.length();i++)
        {
            order[S.charAt(i) - 'a'] = i;
        }

        char[] Ts = T.toCharArray();
        Character[] Tss = new Character[Ts.length];
        for (int i = 0;i<Ts.length;i++)
        {
            Tss[i] = Ts[i];
        }
        Arrays.sort(Tss, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return order[o1-'a'] - order[o2-'a'];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Character c : Tss)
        {
            sb.append(c);
        }
        return sb.toString();
    }
    /*

    public String customSortString(String S, String T) {
        if(S == null || S.length() == 0 || T == null || T.length() == 0){
            return T;
        }
        int[] count = new int[26];
        for(char ch : T.toCharArray()){
            int idx = (int) (ch - 'a');
            count[idx] ++;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : S.toCharArray()){
            int idx = (int)(ch - 'a');
            if(count[idx] > 0){
                char[] part = new char[count[idx]];
                Arrays.fill(part, ch);
                sb.append(new String(part));
                count[idx] = 0;
            }
        }
        for(int i = 0; i < 26; i ++){
            if(count[i] > 0) {
                char[] part = new char[count[i]];
                Arrays.fill(part, (char)('a' + i));
                sb.append(new String(part));
                count[i] = 0;
            }
        }

        return sb.toString();
    }

     */
}
