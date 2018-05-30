public class Question409{
    public int longestPalindrome(String s){
        int[] count = new int[52];
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(c >= 'A' && c <= 'Z'){
                count[c-'A'] += 1;
            }else{
                count[c-'a'+26] += 1;
            }
        }
        int result = 0;
        int hasOdd = 0;
        for(int i = 0;i<52;i++){
            if(count[i] % 2 == 0){
                result += count[i];
            }
            else{
                hasOdd = 1;
                result += count[i]-1;
            }
        }
        return result+hasOdd;
    }
}
