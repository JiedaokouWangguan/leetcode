public class Question342{
    public boolean isPowerOfFour(int num){
        int mask1 = 1;
        int mask2 = 1 << 1;
        while(num > 1){
            if( !((num & mask1) == 0 && (num & mask2) == 0) )
                return false;
            num = num >> 2;
        }
        return true;
    }
}
