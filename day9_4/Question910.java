import java.util.Arrays;

public class Question910{
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int min = A[0] + K;
        int max = A[A.length-1] - K;
        int result = A[A.length-1] - A[0];
        for(int i = 0;i<A.length-1;i++){
            min = Math.min(A[0] + K, A[i+1]-K);
            max = Math.max(A[A.length-1] - K, A[i] + K);
            result = Math.min(result, max - min);
        }
        return result;
    }
}
