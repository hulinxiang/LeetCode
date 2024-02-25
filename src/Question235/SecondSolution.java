package Question235;

/**
 * @author ºúÁØÏè
 * µÝ¹é½â·¨
 */
public class SecondSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val <= p.val && root.val >= q.val) || (root.val <= q.val && root.val >= p.val)) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
}
