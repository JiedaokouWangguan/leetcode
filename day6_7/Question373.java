import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class Tuple implements Comparable<Tuple>{
    int row;
    int col;
    int val;
    public Tuple(int r, int c, int v){
        row = r;
        col = c;
        val = v;
    }
    @Override
    public int compareTo(Tuple that){
        return this.val - that.val;
    }

}

public class Question373{
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k){
        List<int[]> result = new ArrayList<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int rows = nums1.length;
        int cols = nums2.length;
        for(int i = 0;i<cols;i++){
            pq.offer(new Tuple(0, i, nums1[0]+nums2[i]));
        }
        int count = Math.min(k, rows*cols);
        for(int i = 0;i<count;i++){
            Tuple t = pq.poll();
            int[] array = new int[2];
            array[0] = nums1[t.row];
            array[1] = nums2[t.col];
            result.add(array);
            if(t.row >= rows-1)
                continue;
            pq.offer(new Tuple(t.row+1, t.col, nums1[t.row+1]+nums2[t.col]));
        }
        return result;
    }
}
