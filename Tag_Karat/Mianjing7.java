import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

// time compexity is O(nm) where n is the length of array(number of domains) while m is the average length of each domain
// space complexity is O(nk) where n is the number of domain, k is the average number of subdomain of each domain.
// 这个题和后面的dp是一起的，所以这个相对简单，后面那个相对难
// 这个题想法很简单，就是线性遍历，然后记着用String的contains函数和String的indexOf函数，很好用
public class Mianjing7{
    public List<List<String>> countClick(String[][] array){
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] tokens : array){
            String domain = tokens[0];
            int times = Integer.parseInt(tokens[1]);
            map.put(domain, map.getOrDefault(domain, 0) + times);
            while(domain.contains(".")){
                int index = domain.indexOf(".");
                domain = domain.substring(index+1);
                if(domain.length() != 0) map.put(domain, map.getOrDefault(domain, 0) + times);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()){
            List<String> cur = new ArrayList<>();
            cur.add(key);
            cur.add(""+map.get(key));
            result.add(cur);
        }
        return result;
    }
}
