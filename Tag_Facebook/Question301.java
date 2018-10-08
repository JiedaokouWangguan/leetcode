import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Question301{
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> visited = new HashSet<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        queue.offer(s);
        visited.add(s);
        boolean tag = true;
        while(tag && queue.size() > 0){
            int len = queue.size();
            for(int j = 0;j<len;j++){
                String cur = queue.poll();
                if(isValid(cur)) {
                    result.add(cur);
                    tag = false;
                }
                for(int i = 0;i<cur.length();i++){
                    if(cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
                    String tmp = cur.substring(0, i) + cur.substring(i+1, cur.length());
                    if(visited.contains(tmp)) continue;
                    visited.add(tmp);
                    queue.offer(tmp);
                }
            }
        }
        return result;
    }

    private boolean isValid(String s){
        int count = 0;
        for(char c : s.toCharArray()){
            if(c != '(' && c != ')') continue;
            if(c == '(') count += 1;
            else count -= 1;
            
            if(count < 0) return false;
        }
        return true;
    }
}
