package Question2583;

import java.util.HashMap;
import java.util.PriorityQueue;

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


    public long kthLargestLevelSum(TreeNode root, int k) {
        HashMap<Integer,Long> hashMap = new HashMap<>();
        lfs(root, 0, hashMap);
        int layerCount = hashMap.keySet().size();
        if (k > layerCount) {
            return -1;
        }
        return findKthLargest(hashMap, k);
    }

    public long findKthLargest(HashMap<Integer,Long> hashMap, int k) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(((o1, o2) -> o1 > o2 ? -1 : o1.equals(o2) ? 0 : 1));
        priorityQueue.addAll(hashMap.values());
        for (int i = 0; i < k - 1; i++) {
            priorityQueue.remove();
        }
        return priorityQueue.peek();
    }


    public void lfs(TreeNode treeNode, int cur, HashMap<Integer, Long> hashMap) {
        if (treeNode == null) {
            return;
        }
        if (!hashMap.containsKey(cur)) {
            hashMap.put(cur, (long) treeNode.val);
        } else {
            hashMap.replace(cur, hashMap.get(cur) + treeNode.val);
        }
        lfs(treeNode.left, cur + 1, hashMap);
        lfs(treeNode.right, cur + 1, hashMap);
    }


}
