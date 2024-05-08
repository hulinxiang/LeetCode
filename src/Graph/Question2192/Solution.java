package Graph.Question2192;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] ans = new ArrayList[n];
        Arrays.setAll(ans, i -> new ArrayList<>());
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            // 反向建表
            g[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis, false);
            dfs(i, g, vis); //从i开始DFS
            for (int j = 0; j < n; j++) {
                if (vis[j]) {
                    ans[i].add(j);
                }
            }
        }

        return Arrays.asList(ans);
    }

    public void dfs(int x, List<Integer>[] g, boolean[] vis) {
        //避免重复访问
        vis[x] = true;
        for (int y : g[x]) {
            if (!vis[y]) {
                //只递归没有访问过的点
                dfs(y, g, vis);
            }
        }

    }

    public static void main(String[] args) {
        int[][] array = {
                {0, 3},
                {0, 4},
                {1, 3},
                {2, 4},
                {2, 7},
                {3, 5},
                {3, 6},
                {3, 7},
                {4, 6}
        };
        int n = 8;
        System.out.println(new Solution().getAncestors(n, array));
    }

}
