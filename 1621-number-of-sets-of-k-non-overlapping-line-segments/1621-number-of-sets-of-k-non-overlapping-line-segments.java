class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1000000007;
        int N = n + k - 1;
        int[][] dp = new int[N + 1][2 * k + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;

            for (int j = 1; j <= 2 * k && j <= i; j++) {
                dp[i][j] = (int)(((long)dp[i - 1][j - 1] + dp[i - 1][j]) % MOD);
            }
        }

        return dp[N][2 * k];
    }
}