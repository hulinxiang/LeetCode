package Question2312;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        HashMap<Long, Integer> hashMap = new HashMap<>(prices.length);

        for (int[] arr : prices) {
            hashMap.put(parse(arr[0], arr[1]), arr[2]);
        }
        long[][] dp = new long[m + 1][n + 1];
        for (long[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return dfs(dp, hashMap, m, n);
    }

    /**
     * @param dpRes 动态规划的结果
     * @param i     第i行
     * @param j     第j列
     */
    public long dfs(long[][] dpRes, HashMap<Long, Integer> hashMap, int i, int j) {
        if (dpRes[i][j] != -1) {
            return dpRes[i][j];
        }
        long parsed = parse(i, j);
        long res = hashMap.getOrDefault(parsed, 0);
        if (i > 1) {
            for (int x = 1; x < i; x++) {
                res = Math.max(res, dfs(dpRes, hashMap, i - x, j) + dfs(dpRes, hashMap, x, j));
            }
        }
        if (j > 1) {
            for (int y = 1; y < j; y++) {
                res = Math.max(res, dfs(dpRes, hashMap, i, j - y) + dfs(dpRes, hashMap, i, y));
            }
        }
        dpRes[i][j] = res;
        return res;
    }

    public long parse(int x, int y) {
        return (long) x << 16 ^ y;
    }

    public static void main(String[] args) {
        int[][] myArray = {
                {1, 4, 2},
                {2, 2, 7},
                {2, 1, 3}
        };
        int m = 3;
        int n = 5;
        Solution solution = new Solution();
        System.out.println(solution.sellingWood(m, n, myArray));
    }

}
