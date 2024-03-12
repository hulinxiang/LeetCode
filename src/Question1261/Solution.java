package Question1261;

import java.util.HashSet;
import java.util.Stack;

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
class FindElements {
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

    Stack<TreeNode> stack = new Stack<>();
    HashSet<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        root.val = 0;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                set.add(root.val);
                if (root.left != null) {
                    root.left.val = 2 * root.val + 1;
                }
                if (root.right != null) {
                    root.right.val = 2 * root.val + 2;
                }
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }

}
