public class Question10{
    // 6.34 0- 7.0
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for(int j = 1;j<=pLen;j++){
            if(j % 2 == 0 && p.charAt(j-1) == '*' && dp[0][j-2]) dp[0][j] = true;
        }
        for(int i = 1;i<=sLen;i++){
            for(int j = 1;j<=pLen;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                    dp[i][j] = true && dp[i-1][j-1];
                else if(p.charAt(j-1) != '*')
                    dp[i][j] = false;
                else{
                    // 0个，1个，多个
                    boolean res = false;
                    res = res || dp[i][j-2];
                    res = res || dp[i][j-1];
                    if(p.charAt(j-2) == '.' || s.charAt(i-1) == p.charAt(j-2)){
                        res = res || dp[i-1][j];
                    }
                    dp[i][j] = res;
                }
            }
        }
        return dp[sLen][pLen];
    }
}
