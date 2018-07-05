import java.util.ArrayList;
import java.util.List;

public class Question438{
    public List<Integer> findAnagrams(String s, String p) {
        // s is long, p is short

        List<Integer> result = new ArrayList<Integer>();
        int[] count = new int[128];
        for(char c : p.toCharArray())
            count[c] -= 1;
        for(int l = 0, r = 0;r < s.length();r++){
            if(++count[s.charAt(r)] > 0) while(--count[s.charAt(l++)] != 0);
            if(r - l + 1 == p.length()) result.add(l);
        }
        return result;
    }
}
