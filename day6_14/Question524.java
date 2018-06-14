import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Question524{
    public String findLongestWord(String s, List<String> d){
        Collections.sort(d, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.length() == s2.length()? s1.compareTo(s2) : s2.length() - s1.length();
            }
        });
        for(int i = 0;i < d.size();i++){
            if(valid(s, d.get(i)))
                return d.get(i);
        }
        return "";
    }

    private boolean valid(String s, String d){
        int indexD = 0;
        for(int i = 0;i<s.length() && indexD < d.length();i++){
            if(s.charAt(i) == d.charAt(indexD))
                indexD += 1;
        }
        return indexD == d.length();
    }
}
