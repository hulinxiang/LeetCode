package Tree.Question236;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> list = new LinkedList<>();
    HashMap<TreeNode, List<TreeNode>> hashMap = new HashMap<>();
    int p = 0, q = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        List<TreeNode> list1 = hashMap.get(p);
        List<TreeNode> list2 = hashMap.get(q);
        TreeNode res = root;
        for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
            if (list1.get(i) == list2.get(i)) {
                res = list1.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    public void dfs(TreeNode root, TreeNode m, TreeNode n) {
        if (p == 1 && q == 1) {
            return;
        }
        if (root == null) {
            return;
        }
        list.add(root);
        if (root == m) {
            hashMap.put(m, new ArrayList(list));
            p = 1;
        }
        if (root == n) {
            q = 1;
            hashMap.put(n, new ArrayList(list));
        }
        dfs(root.left, m, n);
        dfs(root.right, m, n);
        list.remove(root);
    }


}
