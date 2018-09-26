import java.util.HashSet;
import java.util.HashMap;

public class Question76{
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> mapS = new HashMap<>();
        int unique = 0;
        for(char c : t.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 0);
                unique += 1;
            }
            map.put(c, map.get(c) + 1);
        }
        for (char c : s.toCharArray()){
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }
        for(Character key : map.keySet()){
            if(map.get(key) > mapS.getOrDefault(key, 0)) return "";
        }



        int left = 0;
        int right = 0;
        String result = s;
        while(right < s.length() || (unique == 0 && left < s.length())){
            if(unique == 0 && right - left < result.length()) result = s.substring(left, right);
            if(unique > 0){
                char r = s.charAt(right);
                if (!map.containsKey(r)) {
                    right += 1;
                    continue;
                }
                if(map.get(r) == 1) unique -= 1;
                map.put(r, map.get(r) - 1);
                right += 1;
            }
            else {
                char l = s.charAt(left);
                if(!map.containsKey(l)){
                    left += 1;
                    continue;
                }
                if(map.get(l) == 0) unique += 1;
                map.put(l, map.get(l) + 1);
                left += 1;
            }
        }
        return result;
    }
}
