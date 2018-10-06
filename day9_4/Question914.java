import java.util.HashMap;
import java.util.Map;

public class Question914{
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i : deck){
            count.put(i, count.getOrDefault(i, 0)+1);
        }
        int gcd = 0;
        for(Integer key : count.keySet()){
            gcd = getGCD(count.get(key), gcd);
        }
        return gcd > 1;
    }

    private int getGCD(int a, int b){
        return b > 0?getGCD(b, a%b):a;
    }

}
