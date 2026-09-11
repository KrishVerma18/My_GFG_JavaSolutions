class Solution {
    public int sameMod(int[] arr) {
        Arrays.sort(arr);
        int g = 0;

        for (int i = 1; i < arr.length; i++) {
            g = gcd(g, arr[i] - arr[i - 1]);
        }

        if (g == 0) {
            return -1;
        }

        int count = 0;
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                count++;
                if (i * i != g) {
                    count++;
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}