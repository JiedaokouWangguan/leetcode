import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Question638{
    
    HashMap<List<Integer>, Integer> map = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        return dp(price, special, needs);
    }

    private int dp(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        if(map.containsKey(needs))
            return map.get(needs);
        int min = 0;
        for(int i = 0;i<needs.size();i++){
            min += needs.get(i) * price.get(i);
        }

        for(int i = 0;i<special.size();i++){
            List<Integer> need = new ArrayList<>(needs);
            int j = 0;
            for(;j<needs.size();j++){
                int diff = need.get(j) - special.get(i).get(j);
                if(diff < 0)
                    break;
                need.set(j, diff);
            }
            if(j == needs.size())
                min = Math.min(min, special.get(i).get(need.size()) + dp(price, special, need));
        }
        map.put(needs, min);
        return min;
    }
}
