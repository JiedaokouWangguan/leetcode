import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Question761{
    public String makeLargestSpecial(String S) {
        int count = 0, i = 0;
        List<String> res = new ArrayList<String>();
        for(int j = 0;j<S.length();j++){
            if(S.charAt(j) == '1') count += 1;
            else count -= 1;
            if(count == 0){
                res.add('1' + makeLargestSpecial(S.substring(i+1, j)) + '0');
                i = j + 1;
            }
        }
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }
}
