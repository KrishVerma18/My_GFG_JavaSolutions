class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        long[] diff = new long[n + 1];
        
        for (int i = 0; i < a.length; i++) {
            diff[a[i]] += k[i];
            diff[b[i] + 1] -= k[i];
        }
        
        long max = 0;
        long current = 0;
        
        for (int i = 0; i < n; i++) {
            current += diff[i];
            if (current > max) {
                max = current;
            }
        }
        
        return (int) max;
    }
}