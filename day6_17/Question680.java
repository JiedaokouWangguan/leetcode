public class Question680{
    public boolean validPalindrome(String s){
        return helper(s, 0, s.length()-1, false);
    }

    private boolean helper(String s, int start, int end, boolean tag){
        char[] chars = s.toCharArray();
        while(start < end){
            if(chars[start] == chars[end]){
                start += 1;
                end -= 1;
            }
            else{
                if(tag)
                    return false;
                else{
                    return helper(s, start+1, end, true) || helper(s, start, end-1, true);
                }
            }
        }
        return true;
    }
}
