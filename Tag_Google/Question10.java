public class Question10{
    // 1.35 - 1.48
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for(int i = 1;i<=pLen;i++)
            if(p.charAt(i-1) == '*') dp[0][i] = dp[0][i-2];
        for(int i = 1;i<=sLen;i++){
            for(int j = 1;j<=pLen;j++){
                char sChar = s.charAt(i-1);
                char pChar = p.charAt(j-1);
                if(sChar == pChar || pChar == '.') dp[i][j] = dp[i-1][j-1];
                else if(pChar == '*'){
                    // 0, 1, duoge
                    boolean res = false;
                    res = res || dp[i][j-2];
                    res = res || dp[i][j-1];
                    if(p.charAt(j-2) == '.' || p.charAt(j-2) == sChar)
                        res = res || dp[i-1][j];
                    dp[i][j] = res;
                }
                else dp[i][j] = false;
            }
        }
        return dp[sLen][pLen];
    }
}
