import java.util.Arrays;
import java.util.Comparator;

public class Question646{
    public int findLongestChain(int[][] pairs){
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
                return a1[0] - a2[0];
            }
        });

        int max = 0;
        int[] record = new int[pairs.length];
        return dp(pairs, record, 0);
    }

    private int dp(int[][] pairs, int[] record, int index){
        if(record[index] != 0)
            return record[index];
        
        if(index == record.length-1)
            return 1;

        int nextIndex = -1;
        int end = pairs[index][1];
        int tmpMax = 1;
        for(int i = index+1;i<record.length;i++){
            if(pairs[i][0] > end){
                tmpMax = Math.max(tmpMax, dp(pairs, record, i) + 1);
            }
            else{
                tmpMax = Math.max(tmpMax, dp(pairs, record, i));
            }
        }
        record[index] = tmpMax;
        return tmpMax;
    }
}
