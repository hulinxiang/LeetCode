package Tree.Question637;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {


    public static class TreeNode {
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

    public List<Double> averageOfLevels(TreeNode root) {
        HashMap<Integer, List<Integer>> save = new HashMap<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> depthList = new LinkedList<>();
        list.addLast(root);
        depthList.add(0);
        while (!list.isEmpty()) {
            // 两个同时弹出，保证节点和层数一一对应
            TreeNode treeNode = list.remove();
            int curDepth = depthList.remove();
            if (treeNode != null) {
                if (!save.containsKey(curDepth)) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(treeNode.val);
                    save.put(curDepth, list1);
                } else {
                    save.get(curDepth).add(treeNode.val);
                }
                list.add(treeNode.left);
                depthList.add(curDepth + 1);
                list.add(treeNode.right);
                depthList.add(curDepth + 1);
            }
        }
        List<Double> ret = new ArrayList<>();
        for (List<Integer> layerList : save.values()) {
            double d = layerList.stream().mapToDouble(Integer::doubleValue).average().orElse(0);
            ret.add(d);
        }
        return ret;

    }
}
