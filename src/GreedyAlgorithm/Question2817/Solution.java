package GreedyAlgorithm.Question2817;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 反悔贪心
 */
class Solution {

    public long findMaximumElegance(int[][] items, int k) {
        //从大到小
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        Set<Integer> groups = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        long totalProfit = 0;
        long ans = 0;
        for (int i = 0; i < k; i++) {
            totalProfit += items[i][0];
            // 说明已经有这个类别了，往stack里面添加对应的类别
            if (!groups.add(items[i][1])) {
                stack.add(items[i][0]);
            }
        }
        ans = totalProfit + (long) groups.size() * groups.size();

        for (int i = k; i < items.length; i++) {
            int profit = items[i][0];
            int cate = items[i][1];
            if (!stack.isEmpty() && groups.add(cate)) {
                totalProfit = totalProfit + profit - stack.pop();
            }
            ans = Math.max(ans, totalProfit + (long) groups.size() * groups.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaximumElegance(new int[][]{
                {1, 2}, {10, 1}
        }, 1));
    }
}
