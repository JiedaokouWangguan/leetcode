import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Question890{
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for(String str : words){
            if(match(str, pattern)) result.add(str);
        }
        return result;
    }

    private boolean match(String word, String pattern){
        HashMap<Character, Character> w2p = new HashMap<>();
        HashMap<Character, Character> p2w = new HashMap<>();
        if(word.length() != pattern.length()) return false;
        for(int i = 0;i<word.length();i++){
            char c1 = word.charAt(i);
            char c2 = pattern.charAt(i);
            if(!w2p.containsKey(c1) && !p2w.containsKey(c2)){
                w2p.put(c1, c2);
                p2w.put(c2, c1);
            }
            else if(w2p.containsKey(c1) && p2w.containsKey(c2)){
                if(w2p.get(c1) != c2 || p2w.get(c2) != c1) return false;
            }
            else return false;
        }
        return true;
    }
}
