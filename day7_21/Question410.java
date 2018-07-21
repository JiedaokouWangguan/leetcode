public class Question410{
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for(int n : nums){
            sum += n;
            max = Math.max(max, n);
        }
        if(m == 1) return (int)sum;
        long begin = max;
        long end = sum;
        while(begin <= end){
            long mid = (end + begin)/2;
            if(valid(mid, m, nums))
                end = mid - 1;
            else
                begin = mid + 1;
        }
        return (int)begin;
    }

    private boolean valid(long mid, int m, int[] nums){
        int cur = 0;
        int count = 1;
        for(int n : nums){
            cur += n;
            if(cur > mid){
                cur = n;
                count += 1;
                if(count > m) return false;
            }
        }
        return true;
    }
}
