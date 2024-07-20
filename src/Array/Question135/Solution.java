package Array.Question135;

import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        //        先确定右边评分大于左边的情况（也就是从前向后遍历）
        //
        //        此时局部最优：只要右边评分比左边大，右边的孩子就多一个糖果，全局最优：相邻的孩子中，评分高的右孩子获得比左边孩子更多的糖果
        //
        //        局部最优可以推出全局最优。
        //        再确定左孩子大于右孩子的情况（从后向前遍历）
        //
        //        遍历顺序这里有同学可能会有疑问，为什么不能从前向后遍历呢？
        //
        //        因为 rating[5]与rating[4]的比较 要利用上 rating[5]与rating[6]的比较结果，所以 要从后向前遍历。
        //
        //        如果从前向后遍历，rating[5]与rating[4]的比较 就不能用上 rating[5]与rating[6]的比较结果了
        int[] res = new int[n];
        Arrays.fill(res, 1);
        //从左往右进行一次贪心算法
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int j = n - 1; j > 0; j--) {
            if (ratings[j] < ratings[j - 1]) {
                res[j - 1] = Math.max(res[j] + 1,res[j-1]);
            }
        }
        return Arrays.stream(res).sum();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1, 3, 4, 5, 2}));
    }
}
