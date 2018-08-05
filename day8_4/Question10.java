public class Question10{
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
        for(int i = 0;i< p.length();i++)
            if(p.charAt(i) == '*') dp[i+1][0] = dp[i-1][0];
        for(int pIndex = 0;pIndex < p.length();pIndex++){
            for(int sIndex = 0;sIndex < s.length();sIndex++){
                if(s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.') dp[pIndex+1][sIndex+1] = dp[pIndex][sIndex];
                else if(p.charAt(pIndex) == '*'){
                    if(s.charAt(sIndex) == p.charAt(pIndex-1) || p.charAt(pIndex-1) == '.'){
                        dp[pIndex+1][sIndex+1] = dp[pIndex-1][sIndex+1] || dp[pIndex][sIndex+1] || dp[pIndex+1][sIndex]; 
                    }
                    else dp[pIndex+1][sIndex+1] = dp[pIndex-1][sIndex+1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
