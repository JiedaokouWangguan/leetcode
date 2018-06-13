import java.util.ArrayDeque;

public class Question345{
    public String reverseVowels(String s){
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(isVowel(c))
                stack.push(c);
        }
        for(char c : s.toCharArray()){
            if(isVowel(c))
                sb.append(stack.pop());
            else
                sb.append(c);
        }
        return sb.toString();
    }
    private boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c =='i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c =='I' || c == 'O' || c == 'U')
            return true;
        else
            return false;
    }
}
