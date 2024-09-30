package Tree.Question106;

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        if (inLen != postLen) {
            throw new RuntimeException("Illegal data");
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postLen - 1, hashMap, 0, inLen - 1);

    }

    private TreeNode buildTree(int[] postorder, int postLeft, int postRight,
                               HashMap<Integer, Integer> hashMap, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }
        int rootVal = postorder[postRight];
        TreeNode treeNode = new TreeNode();
        treeNode.val = rootVal;
        int inRootPosition = hashMap.get(rootVal);
        treeNode.left = buildTree(postorder, postLeft, inRootPosition - 1 - inLeft + postLeft, hashMap, inLeft, inRootPosition - 1);
        treeNode.right = buildTree(postorder, postRight - inRight + inRootPosition, postRight - 1, hashMap, inRootPosition + 1, inRight);
        return treeNode;
    }

}
