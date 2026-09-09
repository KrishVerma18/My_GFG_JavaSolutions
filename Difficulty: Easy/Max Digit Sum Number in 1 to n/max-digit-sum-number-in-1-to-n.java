class Solution {
    private int sum(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }

    public int findMax(int n) {
        int bestNum = n;
        int maxSum = sum(n);
        int p = 1;

        while (n > 0) {
            int current = (n - 1) * p + (p - 1);
            int currentSum = sum(current);

            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestNum = current;
            }

            p *= 10;
            n /= 10;
        }

        return bestNum;
    }
}