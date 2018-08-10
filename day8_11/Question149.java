import java.util.HashMap;

public class Question149{
    public int maxPoints(Point[] points) {
        if(points == null) return 0;
        if(points.length <= 2) return points.length;
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int result = 0;
        for(int i = 0;i < points.length; i++){
            map.clear();
            int overlap = 0;
            int max = 0;
            for(int j = i+1; j < points.length;j++){
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if(x == 0 && y == 0){
                    overlap += 1;
                    continue;
                }
                int gcd = getGCD(x, y);
                x /= gcd;
                y /= gcd;
                if(!map.containsKey(x)) map.put(x, new HashMap<Integer, Integer>());
                map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, 1 + overlap + max);
        }
        return result;
    }

    private int getGCD(int a, int b){
        if(b == 0) return a;
        return getGCD(b, a % b);
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
