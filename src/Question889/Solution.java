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
        //ͨ��HashMap�Դﵽһ���ռ任ʱ��Ĳ���
        Map<Integer, Integer> map = new HashMap<>(postLen);
        for (int i = 0; i < preLen; i++) {
            map.put(postorder[i], i);
        }
        return dfs(preorder, postorder, map, 0, preLen - 1, 0, postLen - 1);
    }

    /**
     * @param pre       ǰ������
     * @param post      ��������
     * @param map       hashmap
     * @param preLeft   ǰ����������ĸ��ڵ�λ��
     * @param preRight  ǰ��������������������λ��
     * @param postLeft  ����������������ʼλ��
     * @param postRight ����������ڵ��λ��
     * @return �ýڵ�
     */
    public TreeNode dfs(int[] pre, int[] post, Map<Integer, Integer> map, int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight || postLeft > postRight) {
            return null;
        }
        TreeNode treeNode = new TreeNode();
        //ע�⣬����Ŀ��֮ͬ�������������п���Ϊ�գ�����Ҫ�������´���
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
