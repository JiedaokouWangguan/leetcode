public class Question14{
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String result = strs[0];
        for(int i = 1;i<=result.length();i++){
            for(int j = 1;j<strs.length;j++){
                if(i > strs[j].length() || result.charAt(i-1) != strs[j].charAt(i-1))
                    return result.substring(0, i-1);
            }            
        }                
        return result;                                                                                      
    } 
}
