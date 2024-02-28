package Question2673;

public class Solution {
    /**
     * 用贪心算法,从数组尾端开始,因为index是从0开始的,从数组最后一个叶子节点i开始，那么它的
     * 左兄弟为i-1,它的父节点为(i-1)/2,每次循环i-=2
     */
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n - 1; i > 0; i -= 2) {
            ans += Math.abs(cost[i] - cost[i - 1]);
            cost[(i - 1) / 2] += Math.max(cost[i], cost[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 2, 3, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.minIncrements(7, nums));
    }
}
