public class Question340{
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
}
