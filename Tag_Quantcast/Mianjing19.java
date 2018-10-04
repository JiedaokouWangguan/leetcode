import java.util.List;
import java.util.ArrayList;

public class Mianjing19{
    public List<Integer> mianJing(String s, int n){
        int len = s.length();
        int j = len-1;
        List<Integer> result = new ArrayList<>();
        for(int i = len-2;i>=0;i--){
            if(s.charAt(i) == s.charAt(i+1)){
                if(j - i +1 >= n) result.add(i);
            }
            else{
                j = i;
            }
        }
        return result;
    }
}
