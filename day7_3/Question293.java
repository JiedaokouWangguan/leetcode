import java.util.ArrayList;
import java.util.List;

public class Question293{
    public List<String> generatePossibleNextMoves(String s) {
        ArrayList<String> result = new ArrayList<>();
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                if(s.charAt(i) == '+')
                    result.add(s.substring(0, i-1) + "--" + s.substring(i+1));
            }            
        }                
        return result;                                                                                                           
    }
}
