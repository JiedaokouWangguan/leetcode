import java.util.ArrayList;
import java.util.HashMap;

public class Question760{
    public int[] anagramMappings(int[] B, int[] A) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0;i<A.length;i++){
            int tmp = A[i];
            if(!map.containsKey(tmp))
                map.put(tmp, new ArrayList<Integer>());
            map.get(tmp).add(i);
        }
        int[] result = new int[B.length];
        for(int i = 0;i<B.length;i++){
            ArrayList<Integer> arraylist = map.get(B[i]);
            result[i] = arraylist.get(arraylist.size()-1);
            arraylist.remove(arraylist.size()-1);
        }
        return result;
    }
}
