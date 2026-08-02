class Solution {
    public int count(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int j = 1; j <= m; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= m; k++) {
                    if (j % k == 0 || k % j == 0) {
                        dp[i][j] += dp[i - 1][k];
                    }
                }
            }
        }

        int total = 0;
        for (int j = 1; j <= m; j++) {
            total += dp[n][j];
        }

        return total;
    }
}