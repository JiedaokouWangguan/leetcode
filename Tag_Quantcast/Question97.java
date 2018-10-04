import java.util.HashMap;

public class Question97{
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        return helper(s1, s2, s3);
    }                       

    private boolean helper(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()) return false;
        String key = s1 + "," + s2 + "," + s3; 
        if(map.containsKey(key)) return map.get(key);
        if(s1.length() == 0) return s2.equals(s3);
        if(s2.length() == 0) return s1.equals(s3);
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        char c3 = s3.charAt(0);
        if(c1 == c3 && c2 == c3)
            map.put(key, helper(s1.substring(1), s2, s3.substring(1)) || helper(s1, s2.substring(1), s3.substring(1)));
        else if(c1 == c3) 
            map.put(key, helper(s1.substring(1), s2, s3.substring(1)));
        else if(c2 == c3)                                                                                                        
            map.put(key, helper(s1, s2.substring(1), s3.substring(1)));
        else                
            map.put(key, false);
        return map.get(key);
    }  
}
