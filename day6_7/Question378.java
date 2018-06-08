import java.util.PriorityQueue;

public class Question378{

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

    public int kthSmallest(int[][] matrix, int k){
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for(int i = 0;i<n;i++){
            Tuple t = new Tuple(0, i, matrix[0][i]);
            pq.offer(t);
        }
        for(int i = 0;i<k-1;i++){
            Tuple t = pq.poll();
            if(t.row >= n-1)
                continue;
            pq.offer(new Tuple(t.row+1, t.col, matrix[t.row+1][t.col]));
        }
        return pq.poll().val;

    }
}
