import java.util.HashMap;

public class Question594{
    public int findLHS(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int result = 0;
        for(int k : map.keySet()){
            if(map.containsKey(k+1)){
                result = Math.max(result, map.get(k) + map.get(k+1));
            }
        }
        return result;
    }
}
