class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        List<Long> list = new ArrayList<>();
        long target = x;
        long sum = s;
        list.add(sum);

        for (int num : arr) {
            long val = sum + num;
            if (val > target) {
                break;
            }
            list.add(val);
            sum += val;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (target >= list.get(i)) {
                target -= list.get(i);
            }
        }

        return target == 0;
    }
}