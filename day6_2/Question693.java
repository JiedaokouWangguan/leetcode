public class Question693{
    public boolean hasAlternatingBits(int n){
        int lastBit = n & 1;
        n = n >> 1;
        while(n > 0){
            int curBit = n & 1;
            n = n >> 1;
            if(curBit == lastBit)
                return false;
            else
                lastBit = curBit;
        }
        return true;
    }
}
