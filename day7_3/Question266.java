public class Question266{
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[128];
        char[] chars = s.toCharArray();
        for(char c : chars)
            count[c] += 1;
        boolean tag = false;
        for(int i : count){
            if(i % 2 != 0){
                if(tag)
                    return false;
                else
                    tag = true;
            }
        }
        return true;
    }
}
