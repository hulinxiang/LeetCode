package Question1976;

import java.util.*;

public class Solution {
    public int countPaths(int n, int[][] roads) {
        //最后求得的结果要对mod求模
        int mod = 1000000007;
        List<int[]>[] e = new ArrayList[n];
        //初始化邻接表
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<>();
        }
        //构建邻接表
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            int t = road[2];
            e[x].add(new int[]{y, t});
            e[y].add(new int[]{x, t});
        }
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        int[] ways = new int[n];

        PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        //优先队列里面的long数组中的第一个数字表示从起点到当前节点的已知最短路径的长度
        //第二个元素表示当前节点的索引
        //初始的时候把零节点放入优先队列中
        priorityQueue.offer(new long[]{0, 0});
        //因为是从节点0出发，所以dis[0]=0
        dis[0] = 0;
        ways[0] = 1;

        //这一步是迪杰斯特拉算法的核心,首先
        //t代表从结点0到到节点u的花费
        //u代表的是当前节点u
        //dis[u]表示的是从节点0到节点u所需要的总花费,初始为正无穷大
        while (!priorityQueue.isEmpty()) {
            //因为是优先队列,所以队列头一定是距离最短的
            long[] arr = priorityQueue.poll();
            long t = arr[0];
            int u = (int) arr[1];
            if (t > dis[u]) {
                continue;
            }
            //则在与u节点相关的边中进行遍历
            for (int[] next : e[u]) {
                //v代表与u相邻的某个节点,w代表这个节点的花费
                int v = next[0], w = next[1];
                if (t + w < dis[v]) {
                    dis[v] = t + w;
                    ways[v] = ways[u];
                    priorityQueue.offer(new long[]{t + w, v});
                } else if (t + w == dis[v]) {
                    ways[v] = (ways[u] + ways[v]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}
