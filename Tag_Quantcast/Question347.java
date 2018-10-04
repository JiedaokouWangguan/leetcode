import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Question347{
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
            max = Math.max(map.get(i), max);
        }
        List<List<Integer>> bucket = new ArrayList<>(max+1);
        for(int i = 0;i<=max;i++) bucket.add(new ArrayList<>());
        for(Integer key : map.keySet()){
            int freq = map.get(key);
            bucket.get(freq).add(key);
        }
        List<Integer> result = new ArrayList<>(k);
        for(int i = max;i>=0 && result.size() < k;i--){
            for(int j = 0;result.size() < k &&j<bucket.get(i).size();j++){
                result.add(bucket.get(i).get(j));
            }
        }
        return result;
    }
}
