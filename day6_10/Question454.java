import java.util.HashMap;

public class Question454{
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : A){
            for(int b : B){
                map.put(a+b, map.getOrDefault(a+b, 0) + 1);
            }
        }
        int result = 0;
        for(int c : C){
            for(int d : D){
                result += map.getOrDefault(-c-d, 0);
            }
        }
        return result;
    }
}
