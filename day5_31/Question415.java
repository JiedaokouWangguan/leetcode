public class Question415{
    public String addStrings(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int index = 0;
        int lengthNum1 = num1.length();
        int lengthNum2 = num2.length();
        while(index < Math.max(lengthNum1, lengthNum2)){
            int tmp = carry;
            if(index < lengthNum1)
                tmp += num1.charAt(lengthNum1 - 1 - index) - '0';
            if(index < lengthNum2)
                tmp += num2.charAt(lengthNum2 - 1 - index) - '0';
            sb.append(tmp % 10);
            carry = tmp / 10;
            index += 1;
        }
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
