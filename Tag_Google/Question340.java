public class Question340{
    /*
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) return 0;
        char[] chars = s.toCharArray();
        int unique = 0;
        int[] count = new int[128];
        int max = 0;
        int i = 0; 
        int j = 0; 
        while(j < chars.length){
            char right = chars[j];
            char left = chars[i];
            if(unique < k || (unique == k && count[right] != 0)){
                if(count[right] == 0) unique += 1;
                count[right] += 1;
                j += 1;
                max = Math.max(max, j-i);                                                                                               
            }      
            else{  
                if(count[left] == 1) unique -= 1;
                count[left] -= 1;
                i += 1;
            }      
        }          
        return max;
    }
    */

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) return 0;
        int distinct = 0;
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        int[] count = new int[128];
        int result = 0;
        while(right < chars.length){
            char cLeft = chars[left];
            char cRight = chars[right];
            if(distinct < k || distinct == k && count[right] != 0){
                if(count[right] == 0) distinct += 1;
                count[right] += 1;
                right += 1;
                result = Math.max(result, right - left);
            }
            else {
                if(count[left] == 1) distinct -= 1;
                count[left] -= 1;
                left += 1;
            }
        }
        return result;
    }
}
