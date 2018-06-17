public class Question374{
    int guess(int num){
        return 0;
    }

    public int guessNumber(int n){
        int begin = 1;
        int end = n;
        while(begin <= end){
            int mid = begin + (end - begin)/2;
            int result = guess(mid);
            if(result == 0)
                return mid;
            else if(result == -1)
                end = mid - 1;
            else
                begin = mid + 1;
        }
        return -1;
    }
}
