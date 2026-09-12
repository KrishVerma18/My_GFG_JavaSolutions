class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        if (arr[n - 1] <= 0 && k % 2 != 0) {
            int prod = 1;
            for (int i = n - 1; i >= n - k; i--) {
                prod *= arr[i];
            }
            return prod;
        }

        int prod = 1;
        int i = 0, j = n - 1;

        if (k % 2 != 0) {
            prod *= arr[j];
            j--;
            k--;
        }

        while (k > 0) {
            int leftProd = arr[i] * arr[i + 1];
            int rightProd = arr[j] * arr[j - 1];

            if (leftProd > rightProd) {
                prod *= leftProd;
                i += 2;
            } else {
                prod *= rightProd;
                j -= 2;
            }
            k -= 2;
        }

        return prod;
    }
}