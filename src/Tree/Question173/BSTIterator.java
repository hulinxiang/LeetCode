package Tree.Question173;


import java.util.ArrayList;
import java.util.List;

class BSTIterator {
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

    List<Integer> list;
    int idx;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        idx = 0;
        inOrder(root);
    }

    private void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        list.add(treeNode.val);
        inOrder(treeNode.right);
    }


    public int next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx < list.size();
    }
}
