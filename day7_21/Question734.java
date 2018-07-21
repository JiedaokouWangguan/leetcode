import java.util.HashSet;
import java.util.HashMap;

public class Question734{
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        if(words1.length != words2.length) return false;
        for(String[] pair : pairs){
            String s1 = pair[0];
            String s2 = pair[1];
            if(!map.containsKey(s1)) map.put(s1, new HashSet<String>());
            if(!map.containsKey(s2)) map.put(s2, new HashSet<String>());
            map.get(s1).add(s2);
            map.get(s2).add(s1);
        }
        for(int i = 0;i<words1.length;i++){
            String s1 = words1[i];
            String s2 = words2[i];
            if(s1.equals(s2)) continue;
            if(!map.containsKey(s1)) return false;
            if(!map.get(s1).contains(s2)) return false;
        }
        return true;
    }
}
