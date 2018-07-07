public class Question775{
    public boolean isIdealPermutation(int[] A) {
        int tmp = Integer.MIN_VALUE;
        for(int i = 0;i+1<A.length;i++){
            if(A[i+1] < tmp) return false;
            tmp = Math.max(A[i], tmp);
        }
        return true;
    }
}
