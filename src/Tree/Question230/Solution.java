package Tree.Question230;

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

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return list.get(k - 1);
    }

    public void dfs(TreeNode treeNode, int k) {
        if (list.size() == k) {
            return;
        }
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, k);
        list.add(treeNode.val);
        dfs(treeNode.right, k);
    }

}
