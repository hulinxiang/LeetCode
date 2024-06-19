package Dp.Question2713;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    public int maxIncreasingCells(int[][] mat) {
        // 行数
        int m = mat.length;
        // 列数
        int n = mat[0].length;
        TreeMap<Integer, List<int[]>> g = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 把相同的元素值放在同一组里面,同一组里面记录每个值的位置
                g.computeIfAbsent(mat[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        int ans = 0;
        // 这个是存放每一行的最大值
        int[] rowMax = new int[m];
        // 这个是存放每一列的最大值
        int[] colMax = new int[n];
        for (List<int[]> pos : g.values()) {
            int[] fs = new int[pos.size()];
            for (int k = 0; k < pos.size(); k++) {
                int[] p = pos.get(k);
                int i = p[0];
                int j = p[1];
                fs[k] = Math.max(rowMax[i], colMax[j]) + 1;
                ans = Math.max(ans, fs[k]);
            }
            for (int k = 0; k < pos.size(); k++) {
                int[] p = pos.get(k);
                int i = p[0];
                int j = p[1];
                // 更新第 i 行的最大 f 值
                rowMax[i] = Math.max(rowMax[i], fs[k]);
                // 更新第 j 列的最大 f 值
                colMax[j] = Math.max(colMax[j], fs[k]);
            }
        }
        return ans;
    }
}
