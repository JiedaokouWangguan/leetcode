public class Question190{
    public int reverseBits(int n){
        int[] bits = new int[32];
        for(int i = 0;i<32;i++){
            bits[31-i] = (n & (1 << i)) == 0?0:1;
        }
        int result = 0;
        for(int i = 0;i<32;i++){
            result |= (bits[i] << i);
        }
        return result;
    }
}
