import java.util.HashMap;
import java.util.Arrays;
import java.util.Set;
import java.util.Comparator;
import java.util.HashSet;

public class Question522{
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s2.length() - s1.length();
            }
        });        
        HashSet<String> total = new HashSet<>();
        HashSet<String> dup = new HashSet<>();
        getDup(strs, total, dup);
        for(int i = 0;i<strs.length;i++){
            if(dup.contains(strs[i])) continue;
            if(i == 0 && !dup.contains(strs[i])) return strs[i].length();
            for(int j = 0;j<i;j++){
                if(isSubseq(strs[j], strs[i])) break;
                if(j == i-1) return strs[i].length();
            }
        }
        return -1;
    }
    private boolean isSubseq(String s1, String s2){
        int j = 0;
        for(int i = 0;i<s1.length() && j < s2.length();i++){
            if(s1.charAt(i) == s2.charAt(j)) j++;
        }
        return j == s2.length();
    }
    private void getDup(String[] strs, HashSet<String> total, HashSet<String> dup){
        for(String s : strs){
            if(total.contains(s)) dup.add(s);
            total.add(s);
        }
    }
}
