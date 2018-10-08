public class Question67{
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int aIndex = 0;         
        int bIndex = 0;         
        int carry = 0;          
        StringBuilder sb = new StringBuilder();
        while(aIndex < a.length() && bIndex < b.length()){
            int sum = carry + (a.charAt(aIndex) - '0') + (b.charAt(bIndex) - '0');
            carry = sum / 2;  
            sum = sum % 2;   
            sb.append(sum);
            aIndex++;
            bIndex++;
        }                       
        while(aIndex < a.length()){
            int sum = carry + (a.charAt(aIndex) - '0');
            carry = sum / 2;  
            sum = sum % 2;   
            sb.append(sum);
            aIndex++;
        }                       
        while(bIndex < b.length()){
            int sum = carry + (b.charAt(bIndex) - '0');
            carry = sum / 2;  
            sum = sum % 2;   
            sb.append(sum);  
            bIndex++;
        }                       
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();                                                                                   
    }   
}
