import java.util.HashMap;
import java.util.ArrayDeque;

public class Question792{
    // 3.22 - 
    public int numMatchingSubseq(String S, String[] words) {
        HashMap<Character, ArrayDeque<String>> map = new HashMap<>();
        for(String s : words){
            char c = s.charAt(0);
            if(!map.containsKey(c)) map.put(c, new ArrayDeque<>());
            map.get(c).offer(s);
        }

        int result = 0;
        char[] chars = S.toCharArray();
        for(char c : chars){
            if(!map.containsKey(c) || map.get(c).size() == 0) continue;
            ArrayDeque<String> ad = map.get(c);
            int len = ad.size();
            for(int i = 0;i<len;i++){
                String tmp = ad.poll();
                if(tmp.length() == 1){
                    result += 1;
                }
                else{
                    char tmpChar = tmp.charAt(1);
                    if(!map.containsKey(tmpChar)) map.put(tmpChar, new ArrayDeque<>());
                    map.get(tmpChar).offer(tmp.substring(1));
                }
            }
        }
        return result;
    }
}
