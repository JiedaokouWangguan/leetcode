public class Question917{
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0;             
        int right = chars.length-1;
        while(left < right){  
            while(left < right && !isLetter(chars[left])) left += 1;
            while(left < right && !isLetter(chars[right])) right -= 1;
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left += 1;
            right -= 1;
        }                         
        return new String(chars);                                                                                   
    }                             

    private boolean isLetter(char c){ 
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    } 
}
