public class Question278{
    boolean isBadVersion(int version){
        return bad;
    }

    public int firstBadVersion(int n){
        int begin = 1;
        int end = n;
        while(begin < end){
            int mid = (begin + end)/2;
            if(isBadVersion(mid) == false){
                begin = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return begin;
    }
}
