class Solution {
    static final int MOD = 1_000_000_007;

    int m, n;
    int[][][] memo;

    // dir = 0 means RIGHT, dir = 1 means DOWN
    int[] resolve(int[][] grid, int r, int c, int dir) {

        // Robot grid ke bahar chala gaya
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return new int[]{-1, -1};
        }

        // Empty cell: robot yahan ruk sakta hai
        if (grid[r][c] == 0) {
            return new int[]{r, c};
        }

        // Mirror cell: memoization check
        if (memo[r][c][dir] != -2) {
            return new int[]{
                memo[r][c][dir],
                memo[r][c][dir + 2]
            };
        }

        int nr, nc, ndir;

        if (dir == 0) {
            // RIGHT se mirror mein aaye, ab DOWN
            nr = r + 1;
            nc = c;
            ndir = 1;
        } else {
            // DOWN se mirror mein aaye, ab RIGHT
            nr = r;
            nc = c + 1;
            ndir = 0;
        }

        int[] result = resolve(grid, nr, nc, ndir);

        memo[r][c][dir] = result[0];
        memo[r][c][dir + 2] = result[1];

        return result;
    }

    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 4; d++) {
                    memo[i][j][d] = -2;
                }
            }
        }

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dp[i][j] == 0 || grid[i][j] == 1) {
                    continue;
                }

                // Try moving RIGHT
                if (j + 1 < n) {
                    int[] dest = resolve(grid, i, j + 1, 0);

                    if (dest[0] != -1) {
                        dp[dest[0]][dest[1]] =
                            (dp[dest[0]][dest[1]] + dp[i][j]) % MOD;
                    }
                }

                // Try moving DOWN
                if (i + 1 < m) {
                    int[] dest = resolve(grid, i + 1, j, 1);

                    if (dest[0] != -1) {
                        dp[dest[0]][dest[1]] =
                            (dp[dest[0]][dest[1]] + dp[i][j]) % MOD;
                    }
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}