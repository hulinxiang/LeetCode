package Question2476;

import java.util.ArrayList;
import java.util.List;

public class BetterSolution {
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
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            int val=queries.get(i);
            int leftVal = -1, rightVal = -1;
            int index = binarySearch(res, queries.get(i));
            //说明没有找到对应元素
            if (index != res.size()) {
                rightVal = res.get(index);
                if (res.get(index) == val) {
                    leftVal = val;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(leftVal);
                    list.add(rightVal);
                    ans.add(list);
                    continue;
                }
            }
            if (index > 0) {
                leftVal = res.get(index - 1);
            }
            List<Integer> list2 = new ArrayList<Integer>();
            list2.add(leftVal);
            list2.add(rightVal);
            ans.add(list2);
        }
        return ans;

    }


    //中序遍历
    public void dfs(TreeNode treeNode, List<Integer> values) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, values);
        values.add(treeNode.val);
        dfs(treeNode.right, values);
    }

    private int binarySearch(List<Integer> values, int mark) {
        int left = 0;
        int right = values.size() - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int cur = values.get(mid);
            if (cur == mark) {
                return mid;
            }
            if (cur > mark) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        BetterSolution solution = new BetterSolution();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        System.out.println(solution.binarySearch(list, 5));
        BetterSolution.TreeNode t1 = solution.new TreeNode(1);
        BetterSolution.TreeNode t4 = solution.new TreeNode(4);
        BetterSolution.TreeNode t2 = solution.new TreeNode(2, t1, t4);
        BetterSolution.TreeNode t14 = solution.new TreeNode(14);
        BetterSolution.TreeNode t15 = solution.new TreeNode(15, t14, null);
        BetterSolution.TreeNode t9 = solution.new TreeNode(9);
        BetterSolution.TreeNode t13 = solution.new TreeNode(13, t9, t15);
        BetterSolution.TreeNode t6 = solution.new TreeNode(6, t2, t13);
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(5);
        list1.add(16);
        System.out.println(solution.closestNodes(t6, list1));

    }

}
