import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Collections;

public class Question850{
    int mod = 1000000007;
    public int rectangleArea(int[][] rectangles) {
        List<Point> data = new ArrayList<>();
        for(int[] rec: rectangles){
            data.add(new Point(rec[0], rec[1], 1));
            data.add(new Point(rec[0], rec[3], -1));
            data.add(new Point(rec[2], rec[1], -1));
            data.add(new Point(rec[2], rec[3], 1));
        }                                                                                                                          
        Collections.sort(data, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                return p1.x - p2.x;
            }   
        }); 

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int result = 0;
        int lasty = -1; 
        int lastx = -1; 
        for(int i = 0;i<data.size();i++){
            Point p = data.get(i);
            map.put(p.y, map.getOrDefault(p.y, 0) + p.val);
            if(i == data.size()-1 || p.x < data.get(i+1).x){
                if(lastx != -1){
                    long tmp = ((long)(p.x - lastx) * lasty) % mod;
                    result += tmp;
                    result = result % mod;
                }   
                lastx = p.x;
                lasty = cal(map);
            }   
        }   
        return result;
    }       

    private int cal(TreeMap<Integer, Integer> map){
        int result = 0;
        int lasty = -1; 
        int count = 0;
        for(Integer key : map.keySet()){
            if(map.get(key) == 0) continue;
            if(lasty == -1){
                lasty = key;
                count = map.get(key);
            }   
            else{
                count += map.get(key);
                if(count == 0){ 
                    result += (key - lasty);
                    lasty = -1; 
                }   
            }   
        }   
        return result;
    }
}

class Point{
    int x;
    int y;
    int val;
    public Point(int a, int b, int c){
        x = a;
        y = b;
        val = c;
    }
}
