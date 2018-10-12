import java.util.HashMap;

public class Question97{
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean isInterleave1(String s1, String s2, String s3) {
        return helper(s1, s2, s3);
    }                       

    private boolean helper(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()) return false;
        String key = s1 + "," + s2 + "," + s3; 
        if(map.containsKey(key)) return map.get(key);
        if(s1.length() == 0) return s2.equals(s3);
        if(s2.length() == 0) return s1.equals(s3);
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        char c3 = s3.charAt(0);
        if(c1 == c3 && c2 == c3)
            map.put(key, helper(s1.substring(1), s2, s3.substring(1)) || helper(s1, s2.substring(1), s3.substring(1)));
        else if(c1 == c3) 
            map.put(key, helper(s1.substring(1), s2, s3.substring(1)));
        else if(c2 == c3)                                                                                                        
            map.put(key, helper(s1, s2.substring(1), s3.substring(1)));
        else                
            map.put(key, false);
        return map.get(key);
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int lenS1 = s1.length();
        int lenS2 = s2.length();
        if(lenS1 + lenS2 != s3.length()) return false;
        boolean[][] dp = new boolean[lenS1+1][lenS2+1];
        dp[0][0] = true;
        for(int i = 1;i<=lenS1;i++){
            if(dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1))
                dp[i][0] = true;
        }
        for(int i = 1;i<=lenS2;i++){
            if(dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1))
                dp[0][i] = true;
        }
        for(int i = 1;i<=lenS1;i++){
            for(int j = 1;j<=lenS2;j++){
                if(i == 2 && j == 1){
                    int s = 123;
                }
                if(s1.charAt(i-1) == s3.charAt(i-1 + j) && dp[i-1][j])
                    dp[i][j] = true;
                if(s2.charAt(j-1) == s3.charAt(j-1 + i) && dp[i][j-1])
                    dp[i][j] = true;
            }
        }
        return dp[lenS1][lenS2];
    }
}
