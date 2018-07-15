public class Question686{
    public int binaryGap(int N) {
        int index = -1;
        int result = 0;
        int count = 0;
        while(N > 0){
            if((N & 1) == 1){
                if(index != -1)
                    result = Math.max(result, count - index);
                index = count; 
            }
            count += 1;
            N = N >> 1;
        }
        return result;
    }
}
