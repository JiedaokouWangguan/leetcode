import java.util.HashMap;

public class Question91{

    HashMap<String, Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        return dp(s);   
    }

    private int dp(String s){
        if(s.length() == 0) return 1;
        if(s.charAt(0) == '0') return 0;
        if(map.containsKey(s)) return map.get(s);
        int result = 0;
        result += dp(s.substring(1));
        if(s.length() >= 2 && Integer.parseInt(s.substring(0, 2)) <= 26) result += dp(s.substring(2));
        map.put(s, result);
        return result;
    }
}
