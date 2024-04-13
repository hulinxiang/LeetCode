package Graph.Question2924;

import java.util.*;

public class Solution {
    public int findChampion(int n, int[][] edges) {
        Set<Integer> losers = new HashSet<>();
        //构建邻接表
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int first = e[0];
            int second = e[1];
            g[first].add(second);
        }
        for (int i = 0; i < g.length; i++) {
            losers.addAll(g[i]);
        }
        if (losers.size() == n - 1) {
            for (int i = 0; i < n; i++) {
                if (!losers.contains(i)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
