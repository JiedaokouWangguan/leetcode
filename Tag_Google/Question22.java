import java.util.ArrayList;
import java.util.List;

public class Question22{
    // 2.45 - 2.53, 9mins
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n, n);
        return result;
    }
    
    private void backtrack(List<String> result, String tmpString, int numLeft, int numRight){
        if(numLeft == 0 && numRight == 0){
            result.add(tmpString);
            return;
        }

        if(numLeft == numRight){
            backtrack(result, tmpString+"(", numLeft-1, numRight);
        }
        else if(numLeft < numRight){
            if(numLeft > 0) backtrack(result, tmpString+"(", numLeft-1, numRight);
            backtrack(result, tmpString+")", numLeft, numRight-1);
        }
        else return;
    }
}
