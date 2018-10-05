import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question524{
    // 3.36 - 
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()) return s1.compareTo(s2);
                return s2.length() - s1.length();
            }
        });
        for(String str : d){
            if(match(s, str)) return str;
        }
        return "";
    }

    private boolean match(String s1, String s2){
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i += 1;
                j += 1;
            }
            else{
                i += 1;
            }
        }
        return j == s2.length();
    }
}
