import java.util.Random;
import java.util.HashMap;

class Solution {
    int m = 0;
    Random random = null;
    HashMap<Integer, Integer> map = new HashMap<>();
    public Solution(int N, int[] blacklist) {
        for(int b : blacklist)
            map.put(b, -1);
        
        int len = blacklist.length;
        m = N - len;
        for(int b : blacklist){
            if(b >= m) continue;
            while(map.containsKey(N-1))
                N--;
            map.put(b, N-1);
            N--;
        }
        random = new Random();
    }

    public int pick() {
        int p = random.nextInt(m);
        if(map.containsKey(p))
            return map.get(p);
        return p;
    }
}
