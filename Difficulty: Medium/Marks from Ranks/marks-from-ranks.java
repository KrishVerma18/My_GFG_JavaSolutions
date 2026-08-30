class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        long[] pref = new long[n];
        long total = 0;

        for (int i = 0; i < n; i++) {
            total += (r[i] - l[i] + 1);
            pref[i] = total;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int targetRank : rank) {
            int low = 0, high = n - 1;
            int idx = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (pref[mid] >= targetRank) {
                    idx = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            long prevCount = (idx == 0) ? 0 : pref[idx - 1];
            long offset = targetRank - prevCount;
            ans.add((int) (l[idx] + offset - 1));
        }

        return ans;
    }
}