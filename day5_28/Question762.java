import java.util.HashSet;
import java.util.Arrays;

public class Question762{
    public int countPrimeSetBits(int L, int R){
        HashSet<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29));
        int result = 0;
        for(int i = L;i <= R; i++)
        {
            int tmpResult = 0;
            for(int n = i;n>0;n>>=1)
            {
                if((n & 1) == 1)
                    tmpResult += 1;
            }
            if(set.contains(tmpResult))
                result += 1;
        }
        return result;
    }
}
