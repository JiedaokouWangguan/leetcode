import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

// Time complexity is O(n)
// Space complexity is O(n)

public class Mianjing15{
    public List<List<String>> Question(List<String[]> files){
        HashMap<String, List<String>> map = new HashMap<>();
        for(String[] file : files){
            String path = file[0];
            String content = file[1];
            if(!map.containsKey(content)) map.put(content, new ArrayList<String>());
            map.get(content).add(path);
        }
        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}
