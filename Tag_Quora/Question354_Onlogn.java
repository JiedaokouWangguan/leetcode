import java.util.Arrays;
import java.util.Comparator;

public class Question354_Onlogn{
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                if(i1[0] == i2[0]) return i2[1]-i1[1];
                else return i1[0] - i2[0];
            }
        });
        int[] en = new int[envelopes.length];
        for(int i = 0;i<en.length;i++){
            en[i] = envelopes[i][1];
        }
        int max = 0;
        int[] arr = new int[envelopes.length];
        for(int i = 0;i<en.length;i++){
            int index = Arrays.binarySearch(arr, 0, max, en[i]);
            if(index < 0) index = -(index + 1);
            arr[index] = en[i];
            if(index == max) max += 1;
        }
        return max;
    }
}
