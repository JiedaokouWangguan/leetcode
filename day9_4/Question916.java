import java.util.List;
import java.util.ArrayList;

public class Question916{
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] max = new int[26];
        for(String s : B){
            helper(max, s);
        }
        List<String> result = new ArrayList<>();
        for(String a : A){
            if(helper1(max, a)) result.add(a);
        }
        return result;
    }

    private boolean helper1(int[] max, String s){
        int[] cur = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars){
            cur[c-'a'] += 1;
        }
        for(int i = 0;i<26;i++){
            if(max[i] > cur[i]) return false;
        }
        return true;
    }

    private void helper(int[] max, String s){
        int[] cur = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars){
            cur[c-'a'] += 1;
        }
        for(int i = 0;i<26;i++){
            max[i] = Math.max(max[i], cur[i]);
        }
    }
}
