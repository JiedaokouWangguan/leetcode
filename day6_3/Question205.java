public class Question205{
    public boolean isIsomorphic(String s, String t){
        int[] map = new int[128];
        boolean[] mapped = new boolean[128];
        for(int i = 0;i<s.length();i++){
            if(map[s.charAt(i)] == 0){
                if(!mapped[t.charAt(i)]){
                    map[s.charAt(i)] = t.charAt(i);
                    mapped[t.charAt(i)] = true;
                }
                else{
                    return false;
                }
            }
            else{
                if(map[s.charAt(i)] != t.charAt(i))
                    return false;
            }
        }
        return true;
    }
}
