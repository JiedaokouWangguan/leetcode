import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Question527{
    public List<String> wordsAbbreviation(List<String> dict) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i = 0;i<dict.size();i++){
            String s = dict.get(i);
            String abbr = null;
            if(s.length() <= 3) abbr = s; 
            else abbr = "" + s.charAt(0) + (s.length()-2) + s.charAt(s.length()-1);
            
            if(!map.containsKey(abbr)) map.put(abbr, new ArrayList<Integer>());
            map.get(abbr).add(i);
        }

        String[] result = new String[dict.size()];
        while(map.keySet().size() > 0){
            HashMap<String, List<Integer>> map1 = new HashMap<>();
            for(String abbr : map.keySet()){
                if(map.get(abbr).size() == 1) result[map.get(abbr).get(0)] = abbr;
                else{
                    List<Integer> curList = map.get(abbr);
                    for(int index : curList){
                        String newAbbr = getNewAbbr(abbr, dict.get(index));
                        if(!map1.containsKey(newAbbr)) map1.put(newAbbr, new ArrayList<Integer>());
                        map1.get(newAbbr).add(index);
                    }
                }
            }
            map = map1;
        }

        List<String> res = new ArrayList<>();
        for(String s : result) res.add(s);
        return res;
    }

    private String getNewAbbr(String abbr, String original){
        int index = 0;
        int len = original.length();
        for(;index<abbr.length();index++){
            if(abbr.charAt(index) >= '0' && abbr.charAt(index) <= '9') break;
        }
        int num = Integer.parseInt(abbr.substring(index, abbr.length()-1));
        num -= 1;
        if(num == 1) return original;
        String newAbbr = original.substring(0, len-1-num) + num + original.charAt(len-1);
        return newAbbr;
    }
}
