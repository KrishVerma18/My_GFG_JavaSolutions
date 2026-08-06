class Solution {
    public int countMinOperations(int[] arr) {
        int totalIncrements = 0;
        int maxDoubles = 0;

        for (int num : arr) {
            int count = 0;
            while (num > 0) {
                if (num % 2 == 1) {
                    totalIncrements++;
                    num--;
                } else {
                    count++;
                    num /= 2;
                }
            }
            maxDoubles = Math.max(maxDoubles, count);
        }

        return totalIncrements + maxDoubles;
    }
}