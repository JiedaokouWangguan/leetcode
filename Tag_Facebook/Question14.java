public class Question14{
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String s = strs[0];
        for(int i = 1;i<=s.length();i++){
            for(int j = 0;j<strs.length;j++){
                if(i > strs[j].length() || !strs[j].substring(0, i).equals(s.substring(0, i)))
                    return s.substring(0, i-1);
            }
        }
        return s;
    }
}
