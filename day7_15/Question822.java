import java.util.HashSet;

public class Question822{
    public int flipgame(int[] fronts, int[] backs) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<fronts.length;i++){
            if(fronts[i] == backs[i])
                set.add(backs[i]);
        }             
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<backs.length;i++){
            if(fronts[i] != backs[i]){
                if(!set.contains(backs[i])){
                    min = Math.min(min, backs[i]);
                }
                if(!set.contains(fronts[i])){
                    min = Math.min(min, fronts[i]);
                }   
            }         
        }             
        return min == Integer.MAX_VALUE?0:min;                                                                                                                          
    }
}
