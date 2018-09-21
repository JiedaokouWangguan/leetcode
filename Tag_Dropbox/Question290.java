import java.util.HashSet;
import java.util.HashMap;

public class Question290{
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        char[] ps = pattern.toCharArray();
        String[] strs = str.split(" ");
        if(strs.length != ps.length) return false;
        for(int i = 0;i<ps.length;i++){
            char p = ps[i];
            String s = strs[i];
            if(map.containsKey(p)){
                if(!map.get(p).equals(s)) return false;
            }
            else{
                if(set.contains(s)) return false;
                map.put(p, s);
                set.add(s);
            }
        }
        return true;
    }
}
