public class Question915{
    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        int tmp = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            tmp = Math.max(tmp, A[i]);
            leftMax[i] = tmp;
        }
        tmp = Integer.MAX_VALUE;
        for(int i = n-1;i>=0;i--){
            tmp = Math.min(tmp, A[i]);
            rightMin[i] = tmp;
        }
        for(int i = 0;i<n-1;i++){
            if(leftMax[i] <= rightMin[i+1]) return i+1;
        }
        return -1;
    }
}
