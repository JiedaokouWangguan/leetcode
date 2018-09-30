import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class Question140{
    HashMap<String, List<String>> map = new HashMap<>();    
    // 12.00 - 12.25, 26mins
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s, set);    
    }

    private List<String> helper(String remain, HashSet<String> set){
        if(map.containsKey(remain)) return map.get(remain);
        List<String> tmpResult = new ArrayList<>();
        if(remain.length() == 0){
            tmpResult.add("");
            return tmpResult;
        }
        for(int i = 1;i<=remain.length();i++){
            String subStr = remain.substring(0, i);
            if(!set.contains(subStr)) continue;
            List<String> tmp = helper(remain.substring(i), set);
            if(tmp.size() == 0) continue;
            else if(tmp.size() == 1 && tmp.get(0).equals("")){
                tmpResult.add(subStr);
            }
            else{
                for(int j = 0;j<tmp.size();j++){
                    tmpResult.add(subStr + " " + tmp.get(j));
                }
            }
        }
        map.put(remain, tmpResult);
        return tmpResult;
    }
}
