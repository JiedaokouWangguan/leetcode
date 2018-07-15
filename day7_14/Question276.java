public class Question276{
    public int numWays1(int n, int k) {
        if(n == 0) return 0;
        else if(n == 1) return k;
        int diffColorCounts = k*(k-1);
        int sameColorCounts = k;
        for(int i=2; i<n; i++) {
            int temp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
            sameColorCounts = temp;
        }
        return diffColorCounts + sameColorCounts;
    }

    public int numWays(int n, int k){
        if(n == 0) return 0;
        if(n == 1) return k;
        int diff = k * (k-1);
        int same = k;
        for(int i = 2;i<n;i++){
            int temp = diff;
            diff = (diff + same) * (k-1);
            same = temp;
        }
        return same + diff;
    }
}
