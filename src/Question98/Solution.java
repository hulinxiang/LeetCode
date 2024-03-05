package Question98;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * ���������������������ó��Ľ�����Ǵ�С������ô�ͷ���false�����򷵻�true
     *
     * @param root ���ڵ�
     * @return �Ƿ���һ���������������
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i - 1)) {
                continue;
            }
            return false;
        }
        return true;
    }

    public void dfs(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, list);
        list.add(treeNode.val);
        dfs(treeNode.right, list);
    }

}
