class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();

            if (size1 != size2) return false;

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < size1; i++) {
                Node node1 = q1.poll();
                Node node2 = q2.poll();

                map.put(node1.data, map.getOrDefault(node1.data, 0) + 1);
                map.put(node2.data, map.getOrDefault(node2.data, 0) - 1);

                if (node1.left != null) q1.add(node1.left);
                if (node1.right != null) q1.add(node1.right);

                if (node2.left != null) q2.add(node2.left);
                if (node2.right != null) q2.add(node2.right);
            }

            for (int count : map.values()) {
                if (count != 0) return false;
            }
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}