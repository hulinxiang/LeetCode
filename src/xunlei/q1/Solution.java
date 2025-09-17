package xunlei.q1;


import java.util.*;

public class Solution {

    private HashMap<Integer, Integer> res = new HashMap<>();
    private int minValue = Integer.MAX_VALUE;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n               int整型 节点数（节点编号从 `0` 开始）
     * @param s               int整型 源节点编号
     * @param t               int整型 目标节点编号
     * @param node_bandwidths int整型一维数组 每个节点的可用带宽数组，索引i对应节点i的带宽
     * @param edges           int整型二维数组 边数信息，从左到右分别为：起点节点编号、终点节点编号、链路剩余带宽、传输延迟
     * @param d               int整型 需传输的数据量
     * @return int整型
     */
    public int find_min_delay_path(int n, int s, int t, int[] node_bandwidths, int[][] edges, int d) {
        // write code here
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int start = e[0], end = e[1], remainBand = e[2], delay = e[3];
            if (remainBand < d) {
                continue;
            }
            adj.get(start).add(new Edge(end, delay)); // 有向图
        } // 有向图构建完成
        dfs(t, adj, s, 0, new HashSet<>());
        if (minValue == Integer.MAX_VALUE) {
            return -1;
        }
        return res.get(minValue);

    }

    public static class Edge {
        int e1;// 终点
        int e2;// 延迟

        public Edge(int e1, int e2) {
            this.e1 = e1;
            this.e2 = e2;
        }
    }

    public void dfs(int t, List<List<Edge>> adj, int currentNode, int cost, HashSet<Integer> visited) {
        if (currentNode == t) {
            res.put(cost, res.getOrDefault(cost, 0) + 1);
            if (cost < minValue) {
                minValue = cost;
            }
        } else {
            if (adj.get(currentNode).isEmpty()) {
                return;
            }
            for (Edge e : adj.get(currentNode)) {
                if (visited.contains(e.e1)) {
                    continue;
                }
                visited.add(e.e1);
                dfs(t, adj, e.e1, cost + e.e2, visited);
                visited.remove(e.e1);
            }
        }
    }

}
