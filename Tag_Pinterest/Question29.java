public class Question29{
    public int divide(int dividend1, int divisor1) {
        long dividend = dividend1;
        long divisor = divisor1;
        int sign = 1;
        if(dividend == 0) return 0;
        if(divisor == 0) return -1;
        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
            sign = -1;
        long divi = dividend < 0?-dividend:dividend;
        long divis = divisor < 0?-divisor:divisor;
        if(divis == 1){
            long res = sign * divi;
            return getResult(res);
        }
        else{
            long res = sign * div(divi, divis);
            return getResult(res);
        }
    }
    private int getResult(long res){
        if(res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)res;
    }
    private long div(long dividend, long divisor){
        if(dividend < divisor) return 0;
        long newDivisor = divisor;
        long count = 1;
        while(newDivisor * 2 < dividend){
            newDivisor *= 2;
            count *= 2;
        }
        return count + div(dividend - newDivisor, divisor);
    }
}
