import java.util.PriorityQueue;
import java.util.Comparator;

public class Question378{
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                return matrix[i1[0]][i1[1]] - matrix[i2[0]][i2[1]];
            }
        });

        for(int row = 0;row<rows;row++){
            pq.offer(new int[]{row, 0});
        }

        int result = 0;
        for(int i = 0;i<k;i++){
            int[] tmp = pq.poll();
            result = matrix[tmp[0]][tmp[1]];
            tmp[1] += 1;
            if(tmp[1] >= cols) continue;
            pq.offer(tmp);
        }
        return result;
    }
}
