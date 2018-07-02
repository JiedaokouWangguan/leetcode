import java.util.HashMap;
import java.util.HashSet;

class ValidWordAbbr {    
    HashMap<String, HashSet<String>> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String d : dictionary){
            String word = getString(d);
            if(!map.containsKey(word))
                map.put(word, new HashSet<String>());
            map.get(word).add(d);
        }                
    }                    

    private String getString(String s){
        if(s.length() <= 2)
            return s;    
        return s.charAt(0) + String.valueOf(s.length()-2) + s.charAt(s.length()-1);
    }                    

    public boolean isUnique(String w) {
        String word = getString(w);
        if(!map.containsKey(word) || (map.get(word).size() == 1 && map.get(word).contains(w)))
            return true; 
        else             
            return false;                                                                                                                                                                                   
    }                    
}
