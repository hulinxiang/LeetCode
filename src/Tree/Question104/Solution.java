package Tree.Question104;

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

    private int res = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int curLayer = 1;
        dfs(root, 1);
        return res;
    }

    public void dfs(TreeNode treeNode, int curLayer) {
        if (treeNode == null) {
            return;
        }
        if (curLayer > res) {
            res = curLayer;
        }
        if (treeNode.left != null) {
            dfs(treeNode.left, curLayer + 1);
        }
        if (treeNode.right != null) {
            dfs(treeNode.right, curLayer + 1);
        }
    }


}
