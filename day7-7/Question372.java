public class Question372{
    int base = 1337;
    public int superPow(int a, int[] b){
        if(b == null || b.length == 0) return 1;
        return superP(a, b, b.length-1);
    }

    private int superP(int a, int[] b, int last){
        if(last < 0)
            return 1;
        int tmp = b[last];
        return powmod(superP(a, b, last-1), 10) * powmod(a, tmp) % base;
    }

    private int powmod(int a, int k){
        a %= base;
        int result = 1;
        for(int i = 0;i<k;i++)
            result = (result * a) % base;
        return result;
    }
}
