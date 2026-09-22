class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });

        for (String word : d) {
            if (isSubsequence(word, s)) {
                return word;
            }
        }

        return "";
    }

    private boolean isSubsequence(String word, String s) {
        int i = 0;
        int j = 0;
        int wLen = word.length();
        int sLen = s.length();

        while (i < wLen && j < sLen) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == wLen;
    }
}