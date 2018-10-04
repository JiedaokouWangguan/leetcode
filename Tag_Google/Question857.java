import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question857{
    // 10.04 - 10.21
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        // mini pay / qual = ratio
        double[][] data = new double[wage.length][2];
        for(int i = 0;i<wage.length;i++){
            data[i][0] = wage[i]*1.0/quality[i];
            data[i][1] = quality[i];
        }
        Arrays.sort(data, new Comparator<double[]>(){
            @Override
            public int compare(double[] d1, double[] d2){
                if(d1[0] < d2[0]) return -1;
                else if(d1[0] > d2[0]) return 1;
                else return 0;
            }
        });
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>(){
            @Override
            public int compare(double[] d1, double d2[]){
                if(d1[1] < d2[1]) return 1;
                else if(d1[1] > d2[1]) return -1;
                else return 0;
            }
        });
        double sum = 0;
        int i = 0;
        double curRatio = 0;
        for(;i<K;i++){
            sum += data[i][1];
            curRatio = Math.max(curRatio, data[i][0]);
            pq.offer(data[i]);
        }
        double result = sum * curRatio;
        for(;i<data.length;i++){
            sum -= pq.poll()[1];
            sum += data[i][1];
            curRatio = Math.max(curRatio, data[i][0]);
            pq.offer(data[i]);
            result = Math.min(result, sum * curRatio);
        }
        return result;
    }
}
