import java.util.HashMap;
import java.util.ArrayList;

public class Question350{
    public int[] intersect(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num)){
                list.add(num);
                int count = map.get(num);
                if(count == 1)
                    map.remove(num);
                else
                    map.put(num, count-1);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0;i<result.length;i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
