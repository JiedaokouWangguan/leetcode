public class Question576{

    public int findPaths(int m, int n, int N, int i, int j) {
        int dp[][][] = new int[51][50][50];
        for(int Ni = 1;Ni <= N; Ni ++){
            for(int mi = 0; mi < m;mi++){
                for(int ni = 0;ni<n;ni++){
                    dp[Ni][mi][ni] = ((mi == 0 ? 1 : dp[Ni - 1][mi - 1][ni]) + (mi == m - 1? 1 : dp[Ni - 1][mi + 1][ni])
                            + (ni == 0 ? 1 : dp[Ni - 1][mi][ni - 1]) + (ni == n - 1 ? 1 : dp[Ni - 1][mi][ni + 1])) % 1000000007;
                }
            }
        }
        return dp[N][i][j];
    }
}
