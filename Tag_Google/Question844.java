public class Question844{
    // 9.04 - 9.11, 8mins
    /*
    public boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        helper(s, S);
        helper(t, T);
        if(s.reverse().toString().equals(t.reverse().toString())) return true;
        else return false;
    }

    private void helper(StringBuilder sb, String s){
        int len = s.length()-1;
        int count = 0;
        while(len >= 0){
            if(s.charAt(len) == '#')
                count += 1;
            else{
                if(count > 0) count -= 1;
                else sb.append(s.charAt(len));
            }
            len -= 1;
        }
    }
    */

    public boolean backspaceCompare(String S, String T) {
        if(S == null && T == null) return true;
        if(S == null || T == null) return false;
        return helper(S).equals(helper(T));
    }

    private String helper(String s){
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int index = chars.length-1;
        while(index >= 0){
            if(chars[index] != '#'){
                sb.append(chars[index]);
                index -= 1;
            }
            else{
                index -= 1;
                int count = 1;
                while(index >= 0 && count != 0){
                    if(chars[index] == '#') count += 1;
                    else count -= 1;

                    index -= 1;
                }
            }   
        }
        return sb.toString();
    }
}
