import java.util.List;
import java.util.ArrayList;

public class Question784{
    public List<String> letterCasePermutation(String s){
        s = s.toLowerCase();
        List<String> result = new ArrayList<>();
        backTrack(result, new StringBuilder(), 0, s);
        return result;
    }

    private void backTrack(List<String> result, StringBuilder tmpResult, int index, String s){
        if(index == s.length())
        {
            result.add(tmpResult.toString());
            return;
        }
        tmpResult.append(s.charAt(index));
        backTrack(result, tmpResult, index + 1, s);
        tmpResult.delete(tmpResult.length()-1, tmpResult.length());
        if(s.charAt(index)>= 'a' && s.charAt(index) <= 'z')
        {
            tmpResult.append((char)(s.charAt(index) - 'a' + 'A'));
            backTrack(result, tmpResult, index + 1, s);
            tmpResult.delete(tmpResult.length()-1, tmpResult.length());
        }
    }
}
