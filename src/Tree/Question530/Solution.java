package Tree.Question530;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class TreeNode {
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

    List<Integer> list = new ArrayList<>();
    int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        for (int i = 0; i < list.size() - 1; i++) {
            int cur = Math.abs(list.get(i) - list.get(i + 1));
            if (cur < ans) {
                ans = cur;
            }
        }
        return ans;

    }

    public void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left);
        list.add(treeNode.val);
        dfs(treeNode.right);
    }

}
