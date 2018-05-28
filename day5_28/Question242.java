import java.util.Map;
import java.util.HashMap;

public class Question242{
    public boolean isAnagram(String s, String t){
        int[] map = new int[128];
        for(int i = 0;i<s.length();i++)
        {
            map[s.charAt(i)]++;
        }
        for(int i = 0;i<t.length();i++)
        {
            map[t.charAt(i)]--;
        }
        for(int i = 0;i<128;i++)
        {
            if(map[i] != 0)
                return false;
        }
        return true;
    }

    public boolean isAnagramFollowUp(String s, String t){
        Map<Integer, Integer> dict = new HashMap<>();
        s.codePoints().forEach(code -> dict.put(code, dict.getOrDefault(code, 0) + 1));
        t.codePoints().forEach(code -> dict.put(code, dict.getOrDefault(code, 0) - 1));
        for(int count : dict.values()){
            if(count != 0)
                return false;
        }
        return true;
    }
}
