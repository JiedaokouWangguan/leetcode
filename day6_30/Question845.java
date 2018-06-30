public class Question845{
    public int longestMountain(int[] A) {
        int[] AA = new int[A.length+2];
        for(int i = 0;i<A.length;i++){
            AA[i+1] = A[i];  
        }
        AA[0] = Integer.MAX_VALUE;
        AA[A.length+1] = Integer.MAX_VALUE;
        int[] left2right = new int[A.length+2];
        int[] right2left = new int[A.length+2];
        int cur = 0;
        for(int i = 1;i<AA.length;i++){
            if(AA[i] > AA[i-1])
                left2right[i] = ++cur;
            else
                cur = 0;
        }
        cur = 0;
        for(int i = AA.length-2;i>=0;i--){
            if(AA[i] > AA[i+1])
                right2left[i] = ++cur;
            else
                cur = 0;
        }
        int max = 0;
        for(int i = 0;i<AA.length;i++){
            if(left2right[i] != 0 && right2left[i] != 0 && 1 + left2right[i] + right2left[i] > max)
                max = 1+ left2right[i] + right2left[i];
        }
        return max;
    }
}
