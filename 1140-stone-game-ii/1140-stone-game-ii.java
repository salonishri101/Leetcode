class Solution {

    int[][] dp;

    public int dfs(int[] piles, int i, int M) {

        if (i >= piles.length) {
            return 0;
        }

        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int sum = 0;
        int ans = 0;

        // current player 1 se 2*M piles le sakta hai
        for (int X = 1; X <= 2 * M && i + X <= piles.length; X++) {

            sum += piles[i + X - 1];

            // opponent ka maximum score
            int opponent = dfs(
                piles,
                i + X,
                Math.max(M, X)
            );

            // current player ka score
            ans = Math.max(ans, sum + totalRemaining(piles, i + X) - opponent);
        }

        return dp[i][M] = ans;
    }

    public int totalRemaining(int[] piles, int i) {
        int sum = 0;

        for (int j = i; j < piles.length; j++) {
            sum += piles[j];
        }

        return sum;
    }

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(piles, 0, 1);
    }
}