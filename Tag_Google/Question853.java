import java.util.Arrays;
import java.util.Comparator;

public class Question853{
    public int carFleet(int target, int[] position, int[] speed) {
        if(position == null || position.length == 0) return 0;
        for(int i = 0;i<position.length;i++){
            position[i] = target - position[i];
        }
        double[][] data = new double[position.length][3];
        for(int i = 0;i<data.length;i++){
            data[i][0] = position[i];
            data[i][1] = 1.0*position[i]/speed[i];
        }                       


        Arrays.sort(data, new Comparator<double[]>(){
            @Override           
            public int compare(double[] d1, double[] d2){
                if(d1[0] < d2[0]) return -1; 
                else if(d1[0] > d2[0]) return 1;
                else return 0;
            }                   
        });                                       

        int result = 0;         
        double curMax = -1;         
        for(int i = 0;i<data.length;i++){
            double tmpMax = data[i][1];                                                                                               
            if(tmpMax > curMax){
                curMax = tmpMax;
                result += 1;
            }                   
        }                       
        return result;          
    }
}
