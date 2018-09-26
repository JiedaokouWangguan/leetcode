public class Question3{
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;                                                                         
        int n = s.length();                          
        char[] chars = s.toCharArray();              
        boolean distinct = true;                     
        int left = 0;                                
        int right = 0;                               
        int[] count = new int[127];                  
        int result = 0;                              
        while(right < n){                            
            if(distinct){                            
                if(count[chars[right]] == 1) distinct = false;
                count[chars[right]] += 1;            
                right += 1;                          
            }                                        
            else{                                    
                if(count[chars[left]] == 2) distinct = true;
                count[chars[left]] -= 1;             
                left += 1;                           
            }    
            if(distinct) result = Math.max(result, right - left);
        }                                            
        return result;                               
    }  
}
