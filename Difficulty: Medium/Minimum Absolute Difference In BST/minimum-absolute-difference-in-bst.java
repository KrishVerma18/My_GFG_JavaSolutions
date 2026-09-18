/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int minDiff = Integer.MAX_VALUE;
    Node prev = null;

    public int absDiff(Node root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, root.data - prev.data);
        }
        prev = root;

        inorder(root.right);
    }
}