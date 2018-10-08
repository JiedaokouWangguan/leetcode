public class Question896{
    public boolean isMonotonic(int[] A) {
        boolean inc = true;
        boolean dec = true;
        for(int i = 1;i<A.length;i++){
            if(A[i-1] > A[i]) inc = false;
            if(A[i-1] < A[i]) dec = false;
        }
        return inc || dec;
    }
}
