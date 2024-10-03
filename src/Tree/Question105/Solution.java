package Tree.Question105;

import java.util.HashMap;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        //���ǰ�����еĳ��Ȳ������������г���
        if (preLen != inLen) {
            throw new RuntimeException("error");
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            // ��ŵ�����ڵ��ֵ���������������е�λ��
            hashMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen - 1, hashMap, 0, inLen - 1);
    }


    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, HashMap<Integer, Integer> hashMap, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        // ͨ���������е����Եõ��˸��ڵ�
        TreeNode treeNode = new TreeNode();
        treeNode.val = rootVal;
        int inRootPosition = hashMap.get(rootVal);
        treeNode.left = buildTree(preorder, preLeft + 1, preLeft + inRootPosition - inLeft, hashMap, inLeft, inRootPosition - 1);
        treeNode.right = buildTree(preorder, inRootPosition - inLeft + preLeft + 1, preRight, hashMap, inRootPosition + 1, inRight);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Solution solution = new Solution();
        System.out.println(solution.buildTree(preorder, inorder));
    }

}
