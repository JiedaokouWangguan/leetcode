public class Question278{
    public int firstBadVersion(int n) {
        int begin = 1;
        int end = n;
        while(begin < end){
            int mid = (end - begin)/2 + begin;
            if(isBadVersion(mid)) end = mid;
            else begin = mid + 1;
            // good, bad, bad
        }
        return begin;
    }

    boolean isBadVersion(int version){
        return false;
    }
}
