import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Question609{
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String path : paths) helper(map, path.split(" "));
        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key).size() > 1)
                result.add(map.get(key));
        }
        return result;
    }

    private void helper(HashMap<String, List<String>> map, String[] curPath){
        String dir = curPath[0];
        for(int i = 1;i<curPath.length;i++){
            int index = curPath[i].indexOf("(");
            String filename = curPath[i].substring(0, index);
            String content = curPath[i].substring(index+1, curPath[i].length()-1);
            if(!map.containsKey(content)) map.put(content, new ArrayList<>());
            map.get(content).add(dir+"/"+filename);
        }
    }
}
