import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;
public class Question857{
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[][] fuck = new double[wage.length][2];
        for(int i = 0;i<wage.length;i++){
            fuck[i][0] = wage[i]*1.0/quality[i];
            fuck[i][1] = quality[i];
        }
        Arrays.sort(fuck, new Comparator<double[]>(){
            @Override
            public int compare(double[] i1, double[] i2){
                if(i1[0] == i2[0]) return (int)i1[1] - (int)i2[1];
                else{
                    if(i1[0] < i2[0]) return -1;
                    else if(i1[0] == i2[0]) return 0;
                    else return 1;
                }
            }
        });
        
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>(){
            @Override
            public int compare(double[] i1, double[] i2){
                return (int)i2[1] - (int)i1[1];
            }
        });

        double curSum = 0;
        int i = 0;
        double result = 0;
        for(;i<K-1;i++){
            curSum += fuck[i][1];
            pq.offer(fuck[i]);
        }
        for(;i<fuck.length;i++){
            curSum += fuck[i][1];
            pq.offer(fuck[i]);
            result = Math.min(result, curSum * fuck[i][0]);
            curSum -= pq.poll()[1];
        }
        return result;
    }
}
