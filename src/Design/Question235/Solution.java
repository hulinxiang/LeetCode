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
 * @author ������
 * ����ⷨ
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
            //��Ϊ���ڵ�����������ڵ��ֵ����,��p,q���ڸ��ڵ����
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            //��Ϊ���ڵ�����������ڵ��ֵ��С,��p,q���ڸ��ڵ��ұ�
            else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
