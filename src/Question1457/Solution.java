package Question1457;

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
class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] count = new int[10];
        return calculate(root, count);
    }

    public int calculate(TreeNode root, int[] count) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        count[root.val]++;
        //如果是叶子节点
        if (root.left == null && root.right == null) {
            //如果存在伪回文路径
            if (ifPseudoPalindromicPaths(count)) {
                res++;
            }
        } else {
            res = calculate(root.left, count) + calculate(root.right, count);
        }
        count[root.val]--;
        return res;
    }

    /**
     * 判断是否为伪回文串
     * 如果是偶数长度，那么所有的元素出现的次数必须是偶数的
     * 如果是奇数长度，那么有且仅有一个元素出现的次数可以是奇数
     *
     * @param count
     * @return TRUE 如果是伪回文; False 如果不是伪回文
     */
    public boolean ifPseudoPalindromicPaths(int[] count) {
        int mark = 0;
        for (int val : count) {
            //如果元素出现的次数为奇数
            if (val % 2 == 1) {
                mark++;
            }
        }
        return mark <= 1;
    }
}