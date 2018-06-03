import java.util.HashSet;
import java.util.Arrays;

public class Question720{
    public String longestWord(String[] words){
        Arrays.sort(words);
        HashSet<String> set = new HashSet<>();
        
        int maxLength = 0;
        String result = "";
        for(String s : words){
            if(s.length() == 1 || set.contains(s.substring(0, s.length()-1))){
                if(s.length() > maxLength){
                    maxLength = s.length();
                    result = s;
                }
                else if(s.length() == maxLength){
                    result = s.compareTo(result) < 0?s:result;
                }
                set.add(s);
            }
        }
        return result;
    }
}
