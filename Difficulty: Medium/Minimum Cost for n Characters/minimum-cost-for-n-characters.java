class Solution {
    public int minCost(int n, int i, int d, int c) {
        long[] dp = new long[n + 1];
        dp[0] = 0;

        for (int k = 1; k <= n; k++) {
            dp[k] = dp[k - 1] + i;
            if (k % 2 == 0) {
                dp[k] = Math.min(dp[k], dp[k / 2] + c);
            } else {
                dp[k] = Math.min(dp[k], dp[(k + 1) / 2] + c + d);
            }
        }

        return (int) dp[n];
    }
}