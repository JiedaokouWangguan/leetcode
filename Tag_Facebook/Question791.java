import java.util.HashMap;
import java.util.HashSet;

public class Question791{
    public String customSortString(String S, String T) {
        HashSet<Character> set = new HashSet<>();
        for(char c : S.toCharArray()) set.add(c);
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : T.toCharArray()){
            if(!set.contains(c)) sb.append(c);
            else map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for( char c : S.toCharArray()){
            if(!map.containsKey(c)) continue;
            int count = map.get(c);
            for(int i = 0;i<count;i++) sb.append(c);
        }
        return sb.toString();
    }
}
