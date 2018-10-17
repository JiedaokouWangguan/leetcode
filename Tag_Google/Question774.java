import java.util.PriorityQueue;
import java.util.Comparator;

public class Question774{
    public double minmaxGasDist(int[] stations, int K) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>(){
            @Override
            public int compare(double[] d1, double[] d2){
                if(d2[0]/(d2[1]+1) <  d1[0]/(d1[1]+1)) return -1;
                else if(d2[0]/(d2[1]+1) > d1[0]/(d1[1]+1)) return 1;
                else return 0;
            }
        });   
        for(int i = 1;i<stations.length;i++){
            pq.offer(new double[]{stations[i] - stations[i-1], 0});
        }

        for(int i = 0;i<K;i++){
            double[] cur = pq.poll();
            cur[1] += 1;
            pq.offer(cur);
        }
        
        double[] result = pq.poll();
        return result[0] / (result[1]+1);
    }
}
