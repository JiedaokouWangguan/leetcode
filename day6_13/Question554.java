import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

public class Question554{
    public int leastBricks(List<List<Integer>> wall){
        if(wall == null || wall.size() == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list : wall){
            int sum = 0;
            for(int i = 0;i<list.size()-1;i++){
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        List<Map.Entry<Integer, Integer>> content = new ArrayList<>(map.entrySet());
        Collections.sort(content, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                return e2.getValue() - e1.getValue();
            }
        });
        if(content.size() == 0)
            return wall.size();
        else
            return wall.size() - content.get(0).getValue();
    }
}
