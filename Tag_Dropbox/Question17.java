import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Question17{
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
        
        HashSet<String> set = new HashSet<>();
        set.add("");
        char[] chars = digits.toCharArray();
        for(char c : chars){
            if(!map.containsKey(c)) continue;
            char[] cur = map.get(c);
            HashSet<String> nextSet = new HashSet<>();
            for(String s : set){
                for(char cc : cur){
                    nextSet.add(s+cc);
                }
            }
            set = nextSet;
        }
        List<String> result = new ArrayList<>(set.size());
        for(String str : set) result.add(str);
        return result;
    }
}
