import java.util.ArrayList;

public class Question670{
    public int maximumSwap(int num) {
        char[] digits = (""+num).toCharArray();
        int frist_greater = 0; //find the first digit greater than previous
        while(++frist_greater<digits.length&&digits[frist_greater-1]>=digits[frist_greater]);
        if(frist_greater==digits.length) return num; //all digits are reversed sorted, no swap needed

        char max = '0';               
        int max_position=frist_greater;    
        for(int i=frist_greater;i<digits.length;i++)//find max digit in remain digits
            if(max<=digits[i]){
                max = digits[i];
                max_position = i;
            }

        for(int i=0;i<frist_greater;i++)  //find first digit that smaller than max digit in the second part
            if(max>digits[i]){
                StringBuilder s = new StringBuilder(String.valueOf(digits));
                s.setCharAt(max_position,digits[i]);
                s.setCharAt(i,max);
                return Integer.parseInt(s.toString());  //no need to check overflow since max value is 10^8
            }
        return num;
    }
}
