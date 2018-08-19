import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
public class Question890{
    public List<String> findAndReplacePattern(String[] words, String pattern) { 
        List<String> result = new ArrayList<>();
        for(String s : words){        
            if(check(s, pattern)) result.add(s);
        }                             
        return result;                
    }                                 

    private boolean check(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();       
        HashSet<Character> set = new HashSet<>();                                                                                                                                                           
        for(int i= 0 ;i<s1.length();i++){
            char c1 = s1.charAt(i);   
            char c2 = s2.charAt(i);   
            if(map.containsKey(c1)){ 
                if(map.get(c1) == c2) continue;
                else return false;    
            }                         
            else{                     
                if(set.contains(c2)) return false;
                map.put(c1, c2);      
                set.add(c2);          
            }                         
        }                             
        return true;                  
    }
}
