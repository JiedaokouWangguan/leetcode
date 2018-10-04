import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Question373{
    // 2.05-2.20
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if( nums1 == null||nums1.length ==0 || nums2 == null||nums2.length==0) return new ArrayList<>();
        int rows = nums1.length;
        int cols = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override           
            public int compare(int[] i1, int[] i2){
                int r1 = nums1[i1[0]] + nums2[i1[1]];
                int r2 = nums1[i2[0]] + nums2[i2[1]];
                return r1 - r2;                                                                                                  
            }                   
        });                     

        for(int row = 0;row<rows;row++){
            pq.offer(new int[]{row, 0});
        }                       

        List<int[]> result = new ArrayList<>();
        for(int i = 0;i<k && pq.size() > 0;i++){
            int[] cur = pq.poll();
            result.add(new int[]{nums1[cur[0]], nums2[cur[1]]});      
            if(cur[1] < cols-1){ 
                int[] tmp = new int[]{cur[0], cur[1]+1};
                pq.offer(tmp); 
            }                   
        }                       
        return result;          
    }
}
