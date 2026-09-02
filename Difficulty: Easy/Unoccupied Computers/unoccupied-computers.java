class Solution {
    public int solve(int n, String s) {
        int[] seen = new int[26];
        int occupied = 0;
        int turnedAway = 0;

        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'A';

            if (seen[charIndex] == 0) {
                if (occupied < n) {
                    seen[charIndex] = 1;
                    occupied++;
                } else {
                    seen[charIndex] = 2;
                    turnedAway++;
                }
            } else if (seen[charIndex] == 1) {
                seen[charIndex] = 0;
                occupied--;
            }
        }

        return turnedAway;
    }
}