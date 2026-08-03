class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;
        int[] maxEndingAt = new int[n];
        
        maxEndingAt[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxEndingAt[i] = Math.max(arr[i], maxEndingAt[i - 1] + arr[i]);
        }

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int result = windowSum;

        for (int i = k; i < n; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            result = Math.max(result, windowSum);
            result = Math.max(result, windowSum + maxEndingAt[i - k]);
        }

        return result;
    }
}