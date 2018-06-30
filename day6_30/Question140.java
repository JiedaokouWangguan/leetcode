import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Question140{
    
    HashMap<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict){
        HashSet<String> set = new HashSet<>();
        for(String word : wordDict) set.add(word);
        return helper(s, set);
    }       

    private List<String> helper(String s, HashSet<String> set){
        if(map.containsKey(s))
            return map.get(s);
        String cur = null;
        int index = 0;
        List<String> result = new ArrayList<String>();
        if(s.length() == 0) return result;
        for(int i = 0;i<s.length();i++){
            if(set.contains(s.substring(0, i+1))){
                cur = s.substring(0, i+1);  
                List<String> rest = helper(s.substring(i+1), set);
                if(i == s.length() -1){
                    result.add(cur);
                }
                else{
                    if(rest.size() == 0) continue;
                    for(String r : rest) result.add(cur + " " + r);
                }
            }   
        }                                               
        map.put(s, result);
        return result;
    }
}
