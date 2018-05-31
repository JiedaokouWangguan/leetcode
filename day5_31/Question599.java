import java.util.HashMap;
import java.util.ArrayList;

public class Question599{
    public String[] findRestaurant(String[] list1, String[] list2){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;i<list1.length;i++){
            map.put(list1[i], i);
        }
        int minIndex = Integer.MAX_VALUE;
        ArrayList<String> result = new ArrayList<>();        
        for(int i = 0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                if(i + map.get(list2[i]) < minIndex){
                    result.clear();
                    result.add(list2[i]);
                    minIndex = i + map.get(list2[i]);
                }
                else if(i + map.get(list2[i]) == minIndex)
                    result.add(list2[i]);
            }
        }
        String[] ret = new String[result.size()];
        ret = result.toArray(ret);
        return ret;
    }
}
