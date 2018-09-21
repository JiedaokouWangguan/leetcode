import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Question140{
    HashMap<String, List<String>> dp = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);        
        List<String> result = new ArrayList<>();
        return backtrack(s, set);
    }

    private List<String> backtrack(String s, HashSet<String> set){
        if(dp.containsKey(s)) return dp.get(s);

        List<String> res = new ArrayList<>();
        for(int i = 1;i<=s.length();i++){
            String sub = s.substring(0, i);
            if(!set.contains(sub)) continue;
            if(i == s.length()){
                res.add(sub);
            }
            else{
                List<String> tmp = backtrack(s.substring(i), set);
                if(tmp.size() == 0) continue;
                for(String tmpStr : tmp) res.add(sub + " " + tmpStr);
            }
        }
        dp.put(s, res);
        return res;

    }

    private String buildString(List<String> list){
        StringBuilder sb = new StringBuilder();
        for(String str : list) sb.append(str+" ");
        String res = sb.toString();
        return res.substring(0, res.length()-1);
    }
}
