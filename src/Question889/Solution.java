package Question889;

import java.util.HashMap;
import java.util.Map;

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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int preLen = preorder.length;
        int postLen = postorder.length;
        //通过HashMap以达到一个空间换时间的策略
        Map<Integer, Integer> map = new HashMap<>(postLen);
        for (int i = 0; i < preLen; i++) {
            map.put(postorder[i], i);
        }
        return dfs(preorder, postorder, map, 0, preLen - 1, 0, postLen - 1);
    }

    /**
     * @param pre       前序数组
     * @param post      后序数组
     * @param map       hashmap
     * @param preLeft   前序数组该树的根节点位置
     * @param preRight  前序数组该树的右子树最后位置
     * @param postLeft  后序数组左子树开始位置
     * @param postRight 后序数组根节点的位置
     * @return 该节点
     */
    public TreeNode dfs(int[] pre, int[] post, Map<Integer, Integer> map, int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight || postLeft > postRight) {
            return null;
        }
        TreeNode treeNode = new TreeNode();
        //注意，该题目不同之处在于左子树有可能为空，所以要进行如下处理
        int leftCount = 0;
        if (preLeft < preRight) {
            int postRoot = map.get(pre[preLeft + 1]);
            leftCount = postRoot - postLeft + 1;
        }
        treeNode.val = pre[preLeft];
        treeNode.left = dfs(pre, post, map, preLeft + 1, preLeft + leftCount, postLeft, postLeft + leftCount - 1);
        treeNode.right = dfs(pre, post, map, leftCount + preLeft + 1, preRight, leftCount + postLeft, postRight - 1);
        return treeNode;

    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2, 6, 7, 3, 1};
        Solution solution = new Solution();
        solution.constructFromPrePost(pre, post);
    }


}
