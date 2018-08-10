import java.util.HashSet;

public class Question356{
    public boolean isReflected(int[][] points) {
        HashSet<String> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int[] i : points){
            max = Math.max(i[0], max);
            min = Math.min(i[0], min);
            set.add(i[0] + "-" + i[1]);
        }
        int sum = max + min;
        for(int[] i : points){
            if(!set.contains((sum - i[0] + "-" + i[1])))
                return false;
        }
        return true;
    }
}
