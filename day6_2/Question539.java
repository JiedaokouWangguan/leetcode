import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Question539{
    public int findMinDifference(List<String> timePoints){
        int n = timePoints.size();
        int[] time = new int[n * 2];
        for(int i = 0;i<n;i++){
            String[] t = timePoints.get(i).split(":");
            time[i] = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        }
        for(int i = 0;i<n;i++){
            time[i+n] = time[i] + 24 * 60;
        }
        Arrays.sort(time);
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<time.length;i++){
            min = Math.min(min, time[i]-time[i-1]);
        }
        return min;
    }
}
