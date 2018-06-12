public class Question204{
    public int countPrimes(int n){
        int result = 0;
        boolean[] notPrime = new boolean[n];
        for(int i = 2;i<n;i++){
            if(!notPrime[i]){
                for(int j = 2;j * i < n;j++){
                    notPrime[j*i] = true;
                }
                result += 1;
            }
        }
        return result;
    }
}
