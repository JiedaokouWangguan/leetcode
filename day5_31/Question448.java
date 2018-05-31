import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Question448{
    public List<Integer> findDisappearedNumbers(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(int n : nums){ set.add(n);}
        for(int i = 1;i<= nums.length;i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}
