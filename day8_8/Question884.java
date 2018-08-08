public class Question884{
    public String decodeAtIndex(String S, int K) {
        long len = 0L;
        int i;
        char[] s = S.toCharArray();
        for (i = 0; len < K; i++) len = s[i] >= '0' && s[i] <= '9' ? len*(s[i] - '0') : len + 1;
        i--;
        while(true){
            if(s[i] >= '0' && s[i] <= '9'){
                len /= s[i] - '0';
                K %= len;
            }
            else if(K % len == 0){
                return ""+s[i];
            }
            else
                len -= 1;
            i -= 1;
        }
    }
    public String decodeAtIndex1(String S, int K) {
        long N = 0L;
        int i;
        char[] chs = S.toCharArray();
        for (i = 0; N < K; i++) N = chs[i] >= '0' && chs[i] <= '9' ? N*(chs[i] - '0') : N + 1;
        i--;
        while (true){
            if (chs[i] >= '0' && chs[i] <= '9') {
                N /= chs[i] - '0';
                K %= N;
            } else if (K%N == 0) return "" + chs[i];
            else N--;
            i--;
        }
    }
}
