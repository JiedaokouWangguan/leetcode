import java.util.List;
import java.util.ArrayList;

public class Question830{
    public List<List<Integer>> largeGroupPositions(String S){
        List<List<Integer>> result = new ArrayList<>();
        if(S == null || S.length() < 3)
            return result;

        char[] chars = S.toCharArray();
        char lastChar = chars[0];
        int count = 1;
        for(int i = 1;i<chars.length;i++){
            if(chars[i] == lastChar){
                count += 1;
            }
            else{
                if(count >= 3){
                    List<Integer> tmpResult = new ArrayList<>();
                    tmpResult.add(i-count);
                    tmpResult.add(i-1);
                    result.add(tmpResult);
                }
                count = 1;
                lastChar = chars[i];
            }
        }
        if(count >= 3){
            List<Integer> tmpResult = new ArrayList<>();
            tmpResult.add(chars.length-count);
            tmpResult.add(chars.length-1);
            result.add(tmpResult);
        }
        return result;
    }
}
