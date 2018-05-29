import java.util.HashMap;

public class Question447{
    public int numberOfBoomerangs(int[][] points){
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<points.length;i++){
            map.clear();
            for(int j = 0;j<points.length;j++){
                if(i == j)
                    continue;

                int dis = getDistance(points[i], points[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for(int v : map.values()){
                result += v * (v-1);
            }
        }
        return result;
    }

    private int getDistance(int[] a, int[] b){
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x * x + y * y;
    }
}
