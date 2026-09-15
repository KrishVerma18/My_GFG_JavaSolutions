class Solution {
    public int getCount(Node root, int k) {
        if (root == null) return 0;

        java.util.Queue<Node> nodes = new java.util.LinkedList<>();
        java.util.Queue<Integer> levels = new java.util.LinkedList<>();

        nodes.add(root);
        levels.add(1);

        int count = 0;

        while (!nodes.isEmpty()) {
            Node currNode = nodes.poll();
            int currLevel = levels.poll();

            if (currNode.left == null && currNode.right == null) {
                if (k >= currLevel) {
                    k -= currLevel;
                    count++;
                } else {
                    break;
                }
            }

            if (currNode.left != null) {
                nodes.add(currNode.left);
                levels.add(currLevel + 1);
            }
            if (currNode.right != null) {
                nodes.add(currNode.right);
                levels.add(currLevel + 1);
            }
        }

        return count;
    }
}