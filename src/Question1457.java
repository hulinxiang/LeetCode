/**
 * @author 胡霖翔
 * <p>
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
 * <p>
 * 解题关键：判断一个路径是否是伪回文路径就是看它路径上的值能不能重组成一个真正的回文路径
 */
public class Question1457 {
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

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] count = new int[10];
        return calculate(root, count);
    }

    /**
     * @param root
     * @param count
     * @return 存在的伪回文路径数量
     */
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

    public static void main(String[] args) {
        Question1457 question1457 = new Question1457();
        Question1457.TreeNode t1 = question1457.new TreeNode();
        t1.val = 2;
        Question1457.TreeNode t2 = question1457.new TreeNode();
        t2.val = 3;
        t1.left = t2;
        Question1457.TreeNode t3 = question1457.new TreeNode();
        t3.val = 1;
        t1.right = t3;
        Question1457.TreeNode t4 = question1457.new TreeNode();
        t4.val = 3;
        t2.left = t4;
        Question1457.TreeNode t5 = question1457.new TreeNode();
        t5.val = 1;
        t2.right = t5;
        Question1457.TreeNode t7 = question1457.new TreeNode();
        t7.val = 1;
        t3.right = t7;
        System.out.println(question1457.pseudoPalindromicPaths(t1));
    }

}
