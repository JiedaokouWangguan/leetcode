import java.util.HashMap;
import java.util.HashSet;

public class Question291{
    HashSet<String> set = new HashSet<>();
    HashMap<Character, String> map = new HashMap<>();
    public boolean wordPatternMatch(String pattern, String str) {
        return backtrack(pattern.toCharArray(), 0, str, 0); 
    }                        

    private boolean backtrack(char[] pattern, int patternIndex, String str, int strIndex){
        if(strIndex == str.length() && patternIndex == pattern.length) return true;
        else if(strIndex == str.length() || patternIndex == pattern.length) return false;

        char nextP = pattern[patternIndex];
        if(map.containsKey(nextP)){
            String s = map.get(nextP);
            if(s.length() + strIndex > str.length() || !str.substring(strIndex, strIndex + s.length()).equals(s)) return false;
            return backtrack(pattern, patternIndex+1, str, strIndex+s.length());
        }                    
        else{                
            for(int i = strIndex+1;i <= str.length();i++){
                String tmp = str.substring(strIndex, i);
                if(set.contains(tmp)) continue;
                set.add(tmp);
                map.put(nextP, tmp);
                if(backtrack(pattern, patternIndex+1, str, i)) return true;
                map.remove(nextP);
                set.remove(tmp);
            }                
        }                    
        return false;        
    }         
}
