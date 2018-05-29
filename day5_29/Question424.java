public class Question424{
    public int characterReplacement(String s, int k){
        int[] count = new int[26];
        int maxLength = 0;
        int maxCount = 0;
        int start = 0;
        int end = 0;
        for(;end<s.length();end++){
            maxCount = Math.max(maxCount, ++count[s.charAt(end)-'A']);
            while(end - start + 1 - maxCount > k){
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxCount, end - start + 1);
        }
        return maxLength;
    }
}
