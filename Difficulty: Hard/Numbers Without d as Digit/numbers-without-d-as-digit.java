class Solution {
    public int countWithout(int n, int d) {
        if (n == 0) return 0;

        String s = String.valueOf(n);
        int len = s.length();
        int count = 0;

        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] * 9;
        }

        for (int i = 1; i < len; i++) {
            if (d == 0) {
                count += 9 * dp[i - 1];
            } else {
                count += 8 * dp[i - 1];
            }
        }

        boolean containsD = false;
        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';
            int remainingDigits = len - 1 - i;

            int start = (i == 0) ? 1 : 0;
            for (int j = start; j < digit; j++) {
                if (j != d) {
                    count += dp[remainingDigits];
                }
            }

            if (digit == d) {
                containsD = true;
                break;
            }
        }

        if (!containsD) {
            count++;
        }

        return count;
    }
}