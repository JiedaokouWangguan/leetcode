package leetcode.day8_29;

public class Question738 {
    public int monotoneIncreasingDigits(int N) {
        if(N<=9) return N;
        char[] x = String.valueOf(N).toCharArray();
        int mark = x.length;
        for(int i = x.length-1;i>0;i--){
            if(x[i]<x[i-1]){
                mark = i-1;
                x[i-1]--;
            }
        }
        for(int i = mark+1;i<x.length;i++)x[i] = '9';
        return Integer.parseInt(new String(x));
    }
}
