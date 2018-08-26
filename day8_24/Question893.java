public class Question893{
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> set = new HashSet<>();
        for(String s :A)
            set.add(helper(s));
        return set.size();
    }

    private String helper(String s){
        int[] odd = new int[26];
        int[] even = new int[26];
        for(int i = 0;i<s.length();i++){
            int index = s.charAt(i) - 'a';
            if (i % 2 == 0) even[index] += 1;
            else odd[index] += 1;
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0;i<26;i++){
            for(int j = 0;j<odd[i];j++){
                sb.append('a'+i);
            }
        }
        for (int i = 0;i<26;i++){
            for(int j = 0;j<even[i];j++){
                sb.append('a'+i);
            }
        }
        return sb.toString();
    }
}