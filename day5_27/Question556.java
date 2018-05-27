import java.util.Arrays;

public class Question556{
    
    public int nextGreaterElement(int n){
        char[] number = ("" + n).toCharArray();
        
        boolean canFind = true;
        if(number.length == 1)
            return -1;
        for(int i = 0;i<number.length-1;i++)
        {
            if(number[i] < number[i+1])
                canFind = true;
        }
        if(!canFind)
            return -1;
        int index1 = 0;
        for(int i = number.length-2; i >= 0;i--)
        {
            if(number[i] < number[i+1])
            {
                index1 = i;
                break;
            }
        }
        int index2 = 0;
        for(int i = number.length-1;i>=0;i--)
        {
            if(number[i]> number[index1])
            {
                index2 = i;
                break;
            }
        }
        char tmp = number[index1];
        number[index1] = number[index2];
        number[index2] = tmp;

        Arrays.sort(number, index1+1, number.length);

        // 这里真牛逼，用long来check是不是超过了int的上限
        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int)val : -1;
    }
}
