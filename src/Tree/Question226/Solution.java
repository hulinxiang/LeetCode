package Tree.Question226;

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


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode res = new TreeNode();
        dfs(root, res);
        return res;
    }

    public void dfs(TreeNode root, TreeNode copy) {
        if (root == null) {
            return;
        }
        copy.val = root.val;
        if (root.left != null) {
            copy.right = new TreeNode();
            dfs(root.left, copy.right);
        }
        if (root.right != null) {
            copy.left = new TreeNode();
            dfs(root.right, copy.left);
        }
    }

}
