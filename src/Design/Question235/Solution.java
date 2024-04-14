package Design.Question235;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 *
 * @author 胡霖翔
 * 常规解法
 */

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            //因为根节点比左右两个节点的值都大,故p,q都在根节点左边
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            //因为根节点比左右两个节点的值都小,故p,q都在根节点右边
            else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
