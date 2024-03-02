package Question2368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        //将restricted转化为hashset以提高查找效率
        HashSet<Integer> set = new HashSet<>();
        for (int i : restricted) {
            set.add(i);
        }
        List<Integer>[] g = new ArrayList[edges.length + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int i = e[0];
            int j = e[1];
            g[i].add(j);
            g[j].add(i);
        }
        ArrayList<Integer> visited = new ArrayList<>();
        dfs(g, visited, set, 0, -1);
        return visited.size();
    }

    public void dfs(List<Integer>[] g, ArrayList<Integer> visited, HashSet<Integer> set, int cur, int pre) {
        if (set.contains(cur)) {
            return;
        } else {
            visited.add(cur);
            for (int i : g[cur]) {
                if (i != pre) {
                    dfs(g, visited, set, i, cur);
                }
            }
        }
    }

}
