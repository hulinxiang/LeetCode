package Tree.Question894;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

//还没做完
class Solution {
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

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        TreeNode root = new TreeNode(0);
        dfs(ans, root, root, n - 1);
        return ans;
    }

    // 实现深拷贝的方法
    public TreeNode deepCopy(TreeNode root) {
        TreeNode node = new TreeNode(root.val);
        if (root.left != null) {
            node.left = deepCopy(root.left);
        }
        if (root.right != null) {
            node.right = deepCopy(root.right);
        }
        return node;
    }

    public void dfs(List<TreeNode> ans, TreeNode root, TreeNode cur, int n) {
        if (n == 0) {
            ans.add(deepCopy(root));
            return;
        }
        cur.left = new TreeNode(0);
        cur.right = new TreeNode(0);
        n -= 2;
        dfs(ans, root, cur.left, n);
        dfs(ans, root, cur.right, n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().allPossibleFBT(7));
    }
}