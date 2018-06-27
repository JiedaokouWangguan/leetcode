import java.util.List;
import java.util.ArrayList;

public class Question229{
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int num1 = 0;
        int num2 = 1;
        for(int num : nums){
            if(num == num1)
                count1 += 1;
            else if(num == num2)
                count2 += 1;
            else if(count1 == 0){
                num1 = num;
                count1 = 1;
            }
            else if(count2 == 0){
                num2 = num;
                count2 = 1;
            }
            else{
                count1 -= 1;
                count2 -= 1;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(num == num1)
                count1 += 1;
            if(num == num2)
                count2 += 1;
        }
        if(count1 > (nums.length/3))
            result.add(num1);
        if(count2 > (nums.length/3))
            result.add(num2);
        return result;
    }
}
