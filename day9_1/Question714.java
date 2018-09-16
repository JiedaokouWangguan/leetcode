import java.util.LinkedList;
import java.util.List;

public class Question714{
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length < 2) return 0;
        int n = prices.length;
        List<Integer> list = new LinkedList<>();
        list.add(prices[1] - prices[0]);
        for(int i = 2;i<n;i++){
            int del = prices[i] - prices[i-1];
            if(del == 0) continue;
            if(list.get(list.size()-1) * del >0) list.set(list.size()-1, list.get(list.size()-1) + del);
            else list.add(del);
        }
        if(list.get(0) < 0) list.remove(0);
        if(list.get(list.size()-1) < 0) list.remove(list.size()-1);

    }
}
