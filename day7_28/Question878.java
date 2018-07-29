public class Question878{
    public int nthMagicalNumber(int N, int A, int B) {
        long a = A;
        long b = B;
        long tmp = 0;
        long l = 2;
        long r = (long)Math.pow(10, 14);
        while(b > 0){
            tmp = a;
            a = b;
            b = tmp % b;
        }
        while(l < r){
            long m = (l + r) / 2;
            if(m / A + m / B - m / (A * B / a) < N)
                l = m + 1;
            else 
                r = m;
        }
        return (int)(l % (long)(Math.pow(10, 9) + 7));
    }
}
