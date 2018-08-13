public class Question467{
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int tmpMax = 0;
        for(int i = 0;i<p.length();i++){
            if(i > 0 && (p.charAt(i) == p.charAt(i-1)+1 || p.charAt(i) + 25 == p.charAt(i-1)))
                tmpMax += 1;
            else
                tmpMax = 1;

            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], tmpMax);
        }
        int result = 0;
        for(int i : count) result += i;
        return result;
    }
}
