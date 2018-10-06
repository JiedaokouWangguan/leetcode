import java.util.HashMap;
import java.util.HashSet;

public class Question399{
    HashMap<String, HashSet<String>> map1 = new HashMap<>();
    HashMap<String, Double> map = new HashMap<>();
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        build(equations, values);
        double[] result = new double[queries.length];
        for(int i = 0;i<queries.length;i++){
            HashSet<String> set = new HashSet<>();
            set.add(queries[i][0]);
            result[i] = getResult(queries[i][0], queries[i][1], set);
        }
        return result;
    }

    private double getResult(String a, String b, HashSet<String> set){
        String key = a + "," + b;
        String key2 = b + "," + a;
        double result = -1.0;
        if(map.containsKey(key)) return map.get(key);
        if(!map1.containsKey(a)) return -1;
        for(String nextKey : map1.get(a)){
            if(set.contains(nextKey)) continue;
            double d = map.get(a + "," + nextKey);
            set.add(a);
            Double res = getResult(nextKey, b, set);
            set.remove(a);
            if(res != -1){
                result = d * res;
                break;
            }
        }
        map.put(key, result);
        map.put(key2, 1.0/result);
        return result;
    }

    private void build(String[][] equa, double[] values){
        for(int i = 0;i<equa.length;i++){
            String[] e = equa[i];
            double value = values[i];
            if(!map1.containsKey(e[0])) map1.put(e[0], new HashSet<>());
            if(!map1.containsKey(e[1])) map1.put(e[1], new HashSet<>());
            map1.get(e[0]).add(e[1]);
            map1.get(e[1]).add(e[0]);
            String key1 = e[0] + "," + e[1];
            String key2 = e[1] + "," + e[0];
            map.put(key1, value);
            map.put(key2, 1.0/value);
        }
    }
}
