import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;

public class Question358{
    public String rearrangeString(String s, int k) {
        if (k <= 1) return s;
        if (s.length() == 1) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars)
            map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] a1, int[] a2) {
                if (a2[1] == a1[1]) return a1[0] - a2[0];
                return a2[1] - a1[1];
            }
        });
        for (Character c : map.keySet())
            pq.offer(new int[] { (int) c, map.get(c) });
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            List<int[]> list = new ArrayList<>();
            int nk = k;
            while (nk > 0 && pq.size() > 0) {
                int[] cur = pq.poll();
                sb.append((char) cur[0]);
                cur[1] -= 1;
                nk -= 1;
                if (cur[1] > 0) list.add(cur);
            }
            if (list.size() == 0 && pq.size() == 0) break;
            if (nk != 0) return "";
            for (int[] a : list)
                pq.offer(a);
        }
        return sb.toString();
    }
}
