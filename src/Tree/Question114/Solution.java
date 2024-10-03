package Tree.Question114;

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

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode left = cur.left;
                TreeNode pre = cur.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = left;
            }

            cur = cur.right;
        }
    }

}

