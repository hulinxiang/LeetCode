package Tree.Question103;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        Solution.TreeNode right;

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 如果为空，返回一个空列表
        if (root == null) {
            return List.of();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int mark = 0;
        List<List<Integer>> ans = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            while (size-- > 0) {
                TreeNode node = queue.remove();
                if (mark % 2 == 0) {
                    tmp.addLast(node.val);
                } else {
                    tmp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            mark++;
            ans.add(tmp);
        }
        return ans;
    }
}
