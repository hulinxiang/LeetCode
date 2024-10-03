package Tree.Question129;


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

    int sum = 0;
    int allSum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root);
        return allSum;
    }

    public void dfs(TreeNode treeNode) {
        if (treeNode.left == null && treeNode.right == null) {
            sum = sum * 10 + treeNode.val;
            allSum += sum;
            sum = (sum - treeNode.val) / 10;
            return;
        }
        sum = sum * 10 + treeNode.val;
        if (treeNode.left!=null){
            dfs(treeNode.left);
        }
        if (treeNode.right!=null){
            dfs(treeNode.right);
        }
        sum = (sum - treeNode.val) / 10;
    }


}
