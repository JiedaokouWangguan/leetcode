import java.util.List;
import java.util.ArrayList;

public class Question301{
    public List<String> removeInvalidParentheses(String s){
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> result, int lastI, int lastJ, char[] par){
        int counter = 0;
        for(int i = lastI;i<s.length();i++){
            if(s.charAt(i) == par[0]) counter += 1;
            if(s.charAt(i) == par[1]) counter -= 1;
            if(counter >= 0) continue;
            for(int j = lastJ;j<=i;j++){
                if(par[1] == s.charAt(j) && (j == lastJ || s.charAt(j-1) != par[1]))
                    remove(s.substring(0, j)+s.substring(j+1, s.length()), result, i, j, par);
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(par[0] == '(')
            remove(reversed, result, 0, 0, new char[]{')', '('});
        else
            result.add(reversed);
    }
}
