import java.util.List;
import java.util.ArrayList;

public class Question751{
    public List<String> ipToCIDR(String ip, int n) {
        long start = 0;
        for(String s : ip.split("\\.")) start = start * 256 + Integer.parseInt(s);
        List<String> ans = new ArrayList<>();
        while(n > 0) {
            int num = Math.min((int) (start & -start), Integer.highestOneBit(n));
            ans.add(String.format("%s.%s.%s.%s/%s", start >> 24, (start >> 16) % 256, (start >> 8) % 256, start % 256, 32-Integer.numberOfTrailingZeros(num)));
            start += num;
            n -= num;
        }
        return ans;
    }
}
