import java.util.ArrayList;
import java.util.List;

public class Question905{
    public int[] sortArrayByParity(int[] A) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for(int i : A){
            if(i%2 == 0) even.add(i);
            else odd.add(i);
        }
        int[] result = new int[A.length];
        int index = 0;
        for(int i : even) result[index++] = i;
        for(int i : odd) result[index++] = i;
        return result;
    }
}
