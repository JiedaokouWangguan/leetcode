import java.util.ArrayDeque;

public class Question316{
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        char[] chars = s.toCharArray();
        for(char c : chars){
            count[c-'a'] += 1;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char c : chars){
            count[c-'a'] -= 1;
            if(visited[c-'a'])
                continue;
            while(stack.size() != 0 && stack.peek() > c && count[stack.peek()-'a'] > 0){
                visited[stack.peek()-'a'] = false;
                stack.pop();
            }
            visited[c-'a'] = true;
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() != 0){
            sb.append(""+stack.pop());
        }
        String result = sb.reverse().toString();
        return result;
    }
}
