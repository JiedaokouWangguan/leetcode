import java.util.Arrays;

public class Question3{
    
    // 1.00-1.08
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[128];
        Arrays.fill(count, -1);
        char[] chars = s.toCharArray();
        int j = 0;
        int result = 0;
        for(int i = 0;i<chars.length;i++){
            char curChar = chars[i];
            if(count[curChar] < j){
                result = Math.max(i-j+1, result);
                count[curChar] = i;
            }
            else{
                j = count[curChar]+1;
                count[curChar] = i;
            }
        }
        return result;
    }
}
