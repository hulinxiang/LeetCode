package Tree.Question1026;

public class Solution {
    private int ans;

    //Definition for a binary tree node.
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

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    public void dfs(TreeNode root, int mn, int mx) {
        if (root == null) {
            return;
        }
        mn = Math.min(root.val, mn);
        mx = Math.max(root.val, mx);
        ans = Math.max(ans, mx - mn);
        dfs(root.left, mn, mx);
        dfs(root.right, mn, mx);
    }


}
