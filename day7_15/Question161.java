public class Question161{
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() == t.length())
            return replace(s, t);
        else if(Math.abs(s.length() - t.length()) == 1)
            return s.length() > t.length() ? delete(s, t) : delete(t, s);
        else
            return false;
    }

    private boolean delete(String longer, String shorter){
        int count = 0;
        int j = 0;
        for(int i = 0;i<shorter.length();i++){
            if(longer.charAt(j) != shorter.charAt(i)){
                if(count == 1) return false;
                else{
                    count += 1;
                    i -= 1;
                }
            }
            j++;
        }
        return true;
    }

    private boolean replace(String s1, String s2){
        
        int count = 0;
        for(int i = 0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(count == 1) return false;
                else count += 1;
            }
        }
        return count == 1;
    }
}
