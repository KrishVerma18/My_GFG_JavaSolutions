class Solution {
    public int palindromicStrings(int n, int k) {
        long MOD = 1000000007;
        long total = 0;

        for (int len = 1; len <= n; len++) {
            int m = (len + 1) / 2;
            if (m > k) {
                continue;
            }

            long ways = 1;
            for (int i = 0; i < m; i++) {
                ways = (ways * (k - i)) % MOD;
            }

            total = (total + ways) % MOD;
        }

        return (int) total;
    }
}