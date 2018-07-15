public class Question616{
    public String addBoldTag(String s, String[] dict) {
        if(dict == null || dict.length == 0) return s;
        boolean[] marked = new boolean[s.length()];
        for(String dic : dict)
            mark(s, dic, marked);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();i++){
            if(marked[i] && (i == 0 || !marked[i-1]))
                sb.append("<b>");
            sb.append(s.charAt(i));
            if(marked[i] && (i == s.length()-1 || !marked[i+1]))
                sb.append("</b>");
        }
        return sb.toString();
    }

    private void mark(String s, String dic, boolean[] marked){
        for(int i = 0;i<=s.length() - dic.length();i++){
            String substr = s.substring(i, i+dic.length());
            if(substr.equals(dic)){
                for(int j = i;j<i+dic.length();j++){
                    marked[j] = true;
                }
            }
        }
    }
}
