package leetcode.day8_27;

/**
 * Created by Song on 2018/9/1.
 */
public class Question600 {
    public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));
        String binaryStr = sb.reverse().toString();
        int len = binaryStr.length();
        int[] one = new int[len+1];
        int[] zero = new int[len+1];
        one[1] = 1;
        zero[1] = 1;
        for (int i = 2;i<=len;i++){
            zero[i] = zero[i-1] + one[i-1];
            one[i] = zero[i-1];
        }
        int result = zero[len] + one[len];
        for(int i = len-2;i>=0;i--){
            if(binaryStr.charAt(i) == '1' && binaryStr.charAt(i+1) == '1') break;
            else if(binaryStr.charAt(i) == '0' && binaryStr.charAt(i+1) == '0') result -= one[i+1];
        }
        return result;
    }
}

