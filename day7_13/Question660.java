public class Question660{
    public int newInteger(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }

    public int newInteger1(int n) {
        int ans = 0;
        int base = 1;
            
        while (n > 0){
                ans += n % 9 * base;
                n /= 9;
                base *= 10;
            }
        return ans;
    }
}
