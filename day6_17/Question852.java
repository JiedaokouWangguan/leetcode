public class Question852{
    public int peakIndexInMountainArray(int[] A){
        for(int i = 1;i< A.length;i++){
            if(A[i] > A[i-1] && A[i] > A[i+1])
                return i;
        }
        return -1;
    }
}
