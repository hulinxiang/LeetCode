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

        // ��ȥ��ǰ�ڵ��ֵ
        remainingSum -= node.val;

        // �������Ҷ�ӽڵ㣬�жϵ�ǰ·���ĺ��Ƿ����Ŀ��ֵ
        if (node.left == null && node.right == null) {
            return remainingSum == 0;
        }

        // �ݹ鴦����������
        return dfs(node.left, remainingSum) || dfs(node.right, remainingSum);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.new TreeNode(1);
        treeNode.right = solution.new TreeNode(2);
        System.out.print(solution.hasPathSum(treeNode, 2));
    }

}
