package Tree.Question112;

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum);
    }


    public boolean dfs(TreeNode node, int remainingSum) {
        if (node == null) {
            return false;
        }

        // 减去当前节点的值
        remainingSum -= node.val;

        // 如果到达叶子节点，判断当前路径的和是否等于目标值
        if (node.left == null && node.right == null) {
            return remainingSum == 0;
        }

        // 递归处理左右子树
        return dfs(node.left, remainingSum) || dfs(node.right, remainingSum);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.new TreeNode(1);
        treeNode.right = solution.new TreeNode(2);
        System.out.print(solution.hasPathSum(treeNode, 2));
    }

}
