import java.util.HashMap;
import java.util.ArrayList;
public class Question888{
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] a = A.split(" ");
        String[] b = B.split(" ");

        for(String s : a){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(String s : b){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        ArrayList<String> list = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) == 1)
                list.add(key);
        }
        String[] result = new String[list.size()];
        for(int i = 0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
