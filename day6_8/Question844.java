import java.util.ArrayDeque;

public class Question844{
    public boolean backspaceCompare(String S, String T){
        ArrayDeque<Character> s = new ArrayDeque<>();
        ArrayDeque<Character> t = new ArrayDeque<>();

        for(int i = 0;i<S.length();i++){
            char c = S.charAt(i);
            if(c == '#'){
                if(s.size()!=0)
                    s.pop();
            }
            else{
                s.push(c);
            }
        }
        for(int i = 0;i<T.length();i++){
            char c = T.charAt(i);
            if(c == '#'){
                if(t.size() != 0)
                    t.pop();
            }
            else{
                t.push(c);
            }
        }
        if(s.size() != t.size())
            return false;
        while(s.size() != 0){
            if(s.pop() != t.pop())
                return false;
        }
        return true;
    }
}
