import java.util.HashSet;
import java.util.HashMap;
import java.util.List;

public class Question139{
    // 2.03 - 2.10
    HashMap<Integer, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s, 0, set);
    }

    private boolean helper(String s, int index, HashSet<String> set){
        if(index == s.length()) return true;
        if(map.containsKey(index)) return map.get(index);
        boolean res = false;
        for(int i = index+1;i<=s.length();i++){
            String subStr = s.substring(index, i);
            if(!set.contains(subStr)) continue;
            res = helper(s, i, set);
            if(res) break;
        }
        map.put(index, res);
        return res;
    }
}
