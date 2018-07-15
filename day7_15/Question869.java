public class Question869{
    public boolean reorderedPowerOf2(int N) {
        char[] ch = String.valueOf(N).toCharArray();
        return helper(ch, new boolean[ch.length], 0);
    }

    private boolean helper(char[] chars, boolean[] visited, int cur){
        if(String.valueOf(cur).length() == chars.length){
            if((cur & (cur - 1)) == 0)
                return true;
            else
                return false;
        }
        for(int i = 0;i<chars.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            if (helper(chars, visited, cur * 10 + (chars[i] - '0')))
                return true;
            visited[i] = false;
        }
        return false;
    }
}
