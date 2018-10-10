import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Question49{
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String key = getKey(s);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }

    private String getKey(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder(str.length());
        for(char c : chars) sb.append(c);
        return sb.toString();
    }
}
