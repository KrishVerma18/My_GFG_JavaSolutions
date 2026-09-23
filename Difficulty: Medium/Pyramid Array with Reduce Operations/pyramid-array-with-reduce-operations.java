class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int current = 0;
        for (int i = 0; i < n; i++) {
            current = Math.min(arr[i], current + 1);
            left[i] = current;
        }

        current = 0;
        for (int i = n - 1; i >= 0; i--) {
            current = Math.min(arr[i], current + 1);
            right[i] = current;
        }

        long totalSum = 0;
        for (int x : arr) {
            totalSum += x;
        }

        long maxPyramidSum = 0;
        for (int i = 0; i < n; i++) {
            long h = Math.min(left[i], right[i]);
            long sum = h * h;
            if (sum > maxPyramidSum) {
                maxPyramidSum = sum;
            }
        }

        return (int) (totalSum - maxPyramidSum);
    }
}