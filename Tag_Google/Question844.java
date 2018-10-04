public class Question844{
    // 9.04 - 9.11, 8mins
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
}
