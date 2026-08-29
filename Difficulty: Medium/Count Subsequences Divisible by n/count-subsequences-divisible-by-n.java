class Solution {
    public int countSubsequences(String s, int n) {
        int MOD = 1000000007;
        int len = s.length();
        int[] dp = new int[n];

        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';
            int[] nextDp = dp.clone();

            nextDp[digit % n] = (nextDp[digit % n] + 1) % MOD;

            for (int rem = 0; rem < n; rem++) {
                if (dp[rem] > 0) {
                    int nextRem = (rem * 10 + digit) % n;
                    nextDp[nextRem] = (nextDp[nextRem] + dp[rem]) % MOD;
                }
            }
            dp = nextDp;
        }

        return dp[0];
    }
}