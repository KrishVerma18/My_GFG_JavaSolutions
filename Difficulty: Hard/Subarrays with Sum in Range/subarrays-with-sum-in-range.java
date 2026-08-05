class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        return countAtMost(arr, r) - countAtMost(arr, l - 1);
    }

    private int countAtMost(int[] arr, int k) {
        if (k < 0) return 0;

        int left = 0;
        long sum = 0;
        int count = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > k) {
                sum -= arr[left++];
            }

            count += right - left + 1;
        }

        return count;
    }
}