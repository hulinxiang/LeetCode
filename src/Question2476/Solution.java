package Question2476;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        dfs(root, treeMap);

        List<List<Integer>> ans = new ArrayList<>();
        for (int query : queries) {
            Integer floor = treeMap.floorKey(query);
            Integer ceiling = treeMap.ceilingKey(query);
            List<Integer> cur = new ArrayList<>();

            if (floor != null) {
                cur.add(floor);
            } else {
                cur.add(-1);
                // 用于处理查询值小于所有节点值的情况
            }

            if (ceiling != null) {
                cur.add(ceiling);
            } else {
                cur.add(-1);
                // 用于处理查询值大于所有节点值的情况
            }
            ans.add(cur);
        }
        return ans;
    }

    public void dfs(TreeNode treeNode, TreeMap<Integer, Integer> treeMap) {
        if (treeNode == null) {
            return;
        }
        treeMap.put(treeNode.val, treeNode.val);
        dfs(treeNode.left, treeMap);
        dfs(treeNode.right, treeMap);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = solution.new TreeNode(1);
        TreeNode t4 = solution.new TreeNode(4);
        TreeNode t2 = solution.new TreeNode(2, t1, t4);
        TreeNode t14 = solution.new TreeNode(14);
        TreeNode t15 = solution.new TreeNode(15, t14, null);
        TreeNode t9 = solution.new TreeNode(9);
        TreeNode t13 = solution.new TreeNode(13, t9, t15);
        TreeNode t6 = solution.new TreeNode(6, t2, t13);
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(16);
        System.out.println(solution.closestNodes(t6, list));

    }

}
