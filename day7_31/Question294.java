import java.util.HashMap;

public class Question294{
    HashMap<String, Boolean> map = new HashMap<>();
    
    public boolean canWin(String s) {
        return guaWin(s);        
    }

    private boolean guaWin(String s){
        if(map.containsKey(s)) return map.get(s);
        for(int i = 0;i<s.length()-1;i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                boolean res = guaWin(s.substring(0, i) + "--" + s.substring(i+2));
                if(!res){
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }

}
