import java.util.HashMap;

public class Question290{
    public boolean wordPattern(String pattern, String str){
        HashMap<Character, String> map12 = new HashMap<>();
        HashMap<String, Character> map21 = new HashMap<>();

        char[] chars = pattern.toCharArray();
        String[] strs = str.split(" ");
        if(chars.length != strs.length)
            return false;
        for(int i = 0;i<chars.length;i++){
            char c = chars[i];
            String s = strs[i];
            if(map12.containsKey(c) && map21.containsKey(s)){
                if(!(map12.get(c).equals(s) && map21.get(s) == c)){
                    return false;
                }
            }
            else if(map12.containsKey(c) || map21.containsKey(s))
                return false;
            else{
                map12.put(c, s);
                map21.put(s, c);
            }
        }
        return true;
    }
}
