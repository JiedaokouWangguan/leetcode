package leetcode.day5_14;

public class Question537
{
    public String complexNumberMultiply(String a, String b)
    {
        int[] arrayA = process(a);
        int[] arrayB = process(b);

        int real = arrayA[0] * arrayB[0] - arrayA[1] * arrayB[1];
        int imaginary = arrayA[0] * arrayB[1] + arrayA[1] * arrayB[0];
        String result = "" + real + "+" + imaginary + "i";
        return result;
    }

    private int[] process(String s)
    {
        int[] result = new int[2];
        String[] ss = s.split("\\+");
        result[0] = Integer.parseInt(ss[0]);
        result[1] = Integer.parseInt(ss[1].substring(0, ss[1].length()-1));
        return result;
    }
}
