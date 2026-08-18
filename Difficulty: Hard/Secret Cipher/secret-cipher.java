class Solution {
    public String compress(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        StringBuilder sb = new StringBuilder();
        int i = n - 1;
        while (i >= 0) {
            if (i % 2 == 1) {
                int mid = (i + 1) / 2;
                int len = lps[i];
                boolean matched = false;
                while (len >= mid) {
                    if (len == mid) {
                        matched = true;
                        break;
                    }
                    len = lps[len - 1];
                }
                if (matched) {
                    sb.append('*');
                    i = mid - 1;
                    continue;
                }
            }
            sb.append(s.charAt(i));
            i--;
        }

        return sb.reverse().toString();
    }
}