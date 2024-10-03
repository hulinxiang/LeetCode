package Tree.Question222;

import java.util.LinkedList;
import java.util.List;

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

    int num = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        List<TreeNode> tmp;
        while (!list.isEmpty()) {
            tmp = list;
            list = new LinkedList<>();
            for (TreeNode t : tmp) {
                num++;
                if (t.left != null) {
                    list.add(t.left);
                }
                if (t.right != null) {
                    list.add(t.right);
                }
            }
        }
        return num;
    }
}
