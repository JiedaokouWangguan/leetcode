import java.util.HashMap;

public class Question792{
    HashMap<String, Boolean> map = new HashMap<>();
    public int numMatchingSubseq(String S, String[] words) {
        int result = 0;
        for(String str : words)
            if(isSubseq(S, str)) result += 1;
        return result;
    }

    private boolean isSubseq(String s, String s1){
        if(map.containsKey(s1)) return map.get(s1);
        int j = 0;
        for(int i = 0;i < s.length() && j < s1.length();i++){
            if(s.charAt(i) == s1.charAt(j)) j++;
        }
        map.put(s1, j == s1.length());
        return j == s1.length();
    }
}
