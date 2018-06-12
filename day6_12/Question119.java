import java.util.List;
import java.util.ArrayList;

public class Question119{
    public List<Integer> getRow(int rowIndex){
        int[] tmp = new int[rowIndex+1];
        tmp[0] = 1;
        for(int i = 1;i<=rowIndex;i++){
            for(int k = i;k>0;k--){
                tmp[k] = tmp[k] + tmp[k-1];
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i= 0;i<= rowIndex;i++){
            result.add(tmp[i]);
        }
        return result;
    }
}
