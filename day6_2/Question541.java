public class Question541{
    public String reverseStr(String s, int k){
        char[] str = s.toCharArray();
        for(int i = 0;i<s.length();i=i+k*2){
            helper(str, k, i);
        }
        return String.valueOf(str);
    }

    private void helper(char[] str, int k, int index){
        int n = str.length;
        int begin = index;
        int end = index + k - 1;
        if(index + k - 1 >= n)
            end = n-1;
        // reverse first k chars
        while(begin < end){
            char tmp = str[begin];
            str[begin] = str[end];
            str[end] = tmp;
            begin += 1;
            end -= 1;
        }
    }
}
