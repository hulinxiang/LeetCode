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
            // ���򽨱�
            g[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis, false);
            dfs(i, g, vis); //��i��ʼDFS
            for (int j = 0; j < n; j++) {
                if (vis[j]) {
                    ans[i].add(j);
                }
            }
        }

        return Arrays.asList(ans);
    }

    public void dfs(int x, List<Integer>[] g, boolean[] vis) {
        //�����ظ�����
        vis[x] = true;
        for (int y : g[x]) {
            if (!vis[y]) {
                //ֻ�ݹ�û�з��ʹ��ĵ�
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
