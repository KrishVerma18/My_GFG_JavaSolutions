/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int maxDiffVal = Integer.MIN_VALUE;

    int maxDiff(Node root) {
        solve(root);
        return maxDiffVal;
    }

    private int solve(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            return node.data;
        }

        int leftMin = solve(node.left);
        int rightMin = solve(node.right);

        int childMin = Math.min(leftMin, rightMin);

        maxDiffVal = Math.max(maxDiffVal, node.data - childMin);

        return Math.min(node.data, childMin);
    }
}