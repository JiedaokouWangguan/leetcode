public class Question650{
    public int minSteps(int n){
        int result = 0;
        int p = 2;
        while(n > 1){
            while(n % p == 0){
                result += p;
                n /= p;
            }
            p += 1;
        }
        return result;
    }
}
