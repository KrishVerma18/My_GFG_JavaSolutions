class Solution {
    public int prefixStrings(int n) {
        long mod = 1000000007;
        long[] c = new long[n + 1];
        c[0] = 1;

        for (int i = 1; i <= n; i++) {
            c[i] = 0;
            for (int j = 0; j < i; j++) {
                c[i] = (c[i] + (c[j] * c[i - 1 - j]) % mod) % mod;
            }
        }

        return (int) c[n];
    }
}