import java.util.PriorityQueue;
import java.util.Comparator;

public class Question502{
    // int[profit, capital]
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pqCapital = new PriorityQueue<>(new Comparator<int[]>(){
            @Override                  
            public int compare(int[] i1, int[] i2){
                return i1[1] - i2[1];
            }                          
        });                            

        PriorityQueue<int[]> pqProfit = new PriorityQueue<>(new Comparator<int[]>(){
            @Override                  
            public int compare(int[] i1, int[] i2){
                return i2[0] - i1[0];
            }                          
        });                            

        for(int i = 0;i<Profits.length;i++){
            pqCapital.offer(new int[]{Profits[i], Capital[i]});
        }                              

        while(k > 0){                  
            while(pqCapital.size() > 0 && pqCapital.peek()[1] <= W) pqProfit.offer(pqCapital.poll());
            if(pqProfit.size() == 0) return W;
            else W += pqProfit.poll()[0];
            k -= 1;
        }                              
        return W;                      
    }
}
