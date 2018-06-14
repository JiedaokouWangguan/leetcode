public class Question459{
    public boolean repeatedSubstringPattern(String s){
        String ss = s+s;
        ss = ss.substring(1, ss.length()-1);
        return ss.indexOf(s) != -1;
    }
}
