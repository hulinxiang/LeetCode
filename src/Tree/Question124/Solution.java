package Tree.Question124;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private int max = Integer.MIN_VALUE;


    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            // 空节点的贡献度为0
            return 0;
        }
        int leftVal = Math.max(dfs(node.left), 0);
        int rightVal = Math.max(dfs(node.right), 0);
        int nodeVal = leftVal + rightVal + node.val;
        max = Math.max(nodeVal, max);
        return node.val + Math.max(leftVal, rightVal);

    }


}
