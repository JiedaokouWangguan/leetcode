public class Question471{
    public String encode(String s) {
        if (s == null || s.length() < 5) return s;
        int n = s.length();
        String[][] dp = new String[n][n];

        for (int len = 0; len < n; len++) {
            for (int begin = 0; begin < n - len; begin++) {
                int end = begin + len;
                String subStr = s.substring(begin, end + 1);
                dp[begin][end] = subStr;
                if (len < 4) continue;

                for (int mid = begin; mid < end; mid++) {
                    String tmp = dp[begin][mid] + dp[mid + 1][end];
                    if (tmp.length() < dp[begin][end].length()) dp[begin][end] = tmp;
                }

                for (int i = 1; i <= subStr.length(); i++) {
                    String curSubStr = subStr.substring(0, i);
                    if (subStr.length() % curSubStr.length() == 0
                            && subStr.replaceAll(curSubStr, "").length() == 0) {
                        String tmp = subStr.length() / curSubStr.length() + "["
                            + dp[begin][begin + i - 1] + "]";
                        if (tmp.length() < dp[begin][end].length()) {
                            dp[begin][end] = tmp;
                        }
                            }
                }
            }
        }
        return dp[0][n - 1];
    }
}
