import java.util.List;
import java.util.ArrayList;

public class Question89{
    public List<Integer> grayCode(int n) {
        return getGray(n);   
    }

    private List<Integer> getGray(int n){
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i< 1<<n;i++){
            result.add(i^i>>1);
        }
        return result;
    }
}
