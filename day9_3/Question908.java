public class Question908{
    // 10.0-10.5
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i : A){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return min + K > max - K?0:max - K - min - K;
    }
}
