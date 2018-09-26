import java.util.HashMap;

public class Mianjing11{
    
}

// 8.08 - 8.31
// 主要是麻烦一点，并不难，要问清当操作有错误的时候返回什么
// Time complexity is O(n) （各种操作）where n is the parameter n
// Space Complexity is O(M) where m is the number of non-zero value

class SparseVector{
    int n = 0;
    HashMap<Integer, Integer> v = new HashMap<>();
    public SparseVector(int n){
        this.n = n;
    }

    public void set(int index, int value){
        v.put(index, value);
    }
    
    public int dot(SparseVector sv){
        int result = 0;
        for(Integer index : v.keySet()){
            result += v.get(index) * sv.v.getOrDefault(index, 0);
        }
        return result;
    }

    public SparseVector add(SparseVector sv){
        SparseVector result = new SparseVector(n);
        for(Integer index : v.keySet()){
            result.v.put(index, result.v.getOrDefault(index, 0) + v.get(index));
        }
        for(Integer index : sv.v.keySet()){
            result.v.put(index, result.v.getOrDefault(index, 0) + sv.v.get(index));
        }
        return result;
    }

    public double cos(SparseVector sv){
        double result = dot(sv);
        result = result / (getNorm() * sv.getNorm());
        return result;
    }

    private double getNorm(){
        double res = 0;
        for(Integer key : v.keySet()){
            res += v.get(key) * v.get(key);
        }
        res = Math.sqrt(res);
        return res;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            int value = 0;
            if(v.containsKey(i)) value = v.get(i);
            sb.append(value + ",");
        }
        String result = sb.toString();
        result = result.substring(0, result.length()-1);
        result = "[" + result + "]";
        return result;
    }

}
