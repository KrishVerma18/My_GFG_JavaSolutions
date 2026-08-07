class Solution {
    public int countFriendsPairings(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = b + (i - 1) * a;
            a = b;
            b = c;
        }
        return b;
    }
}