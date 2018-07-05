import java.util.HashSet;
import java.util.HashMap;

public class Question567{
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        for (int i = 0; i < s1.length(); i++)
            count[s1.charAt(i)]--;
        for (int l = 0, r = 0; r < s2.length(); r++) {
            if (++count[s2.charAt(r)] > 0) while (--count[s2.charAt(l++)] != 0);
            else if ((r - l + 1) == s1.length()) return true;
        }
        return s1.length() == 0;
    }
    // awesome apporoach
    
    public boolean checkInclusion1(String s1, String s2){
        int[] map = new int[s1.length()];
        for(char c : s1.toCharArray())
            map[c] -= 1;
        for(int l = 0, r = 0;r < s2.length();r++){
            if(++map[s2.charAt(r)] > 0) while(--map[s2.charAt(l++)] != 0);
            else if(r - l + 1 == s1.length()) return true;
        }
        return s1.length() == 0;
    }
}
