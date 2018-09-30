import java.util.ArrayDeque;

public class Question66{
    // 11.55 - 11.58, 4mins
    public int[] plusOne(int[] digits) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int carry =1;
        for(int i = digits.length-1;i>=0;i--){
            int num = digits[i] + carry;
            carry = num/10;
            num = num%10;
            stack.push(num);
        }
        if(carry != 0) stack.push(carry);
        int[] result = new int[stack.size()];
        for(int i = 0;i<result.length;i++){
            result[i] = stack.pop();
        }
        return result;
    }
}
