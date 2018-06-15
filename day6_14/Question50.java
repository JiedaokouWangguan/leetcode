public class Question50{
    public double myPow(double x, int in){
        boolean isPos = true;
        long n = in;
        if(n < 0){
            isPos = false;
            n = -n;
        }
        double result = 1;
        double cur = x;
        while(n > 0){
            if((n & 1) == 1){
                cur = cur * cur;
            }
            cur *= 2;
            n = (n >> 1);
        }
        return isPos ? result : 1/result;
    }
}
