package Question1976;

import java.util.*;

public class Solution {
    public int countPaths(int n, int[][] roads) {
        //�����õĽ��Ҫ��mod��ģ
        int mod = 1000000007;
        List<int[]>[] e = new ArrayList[n];
        //��ʼ���ڽӱ�
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<>();
        }
        //�����ڽӱ�
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
        //���ȶ��������long�����еĵ�һ�����ֱ�ʾ����㵽��ǰ�ڵ����֪���·���ĳ���
        //�ڶ���Ԫ�ر�ʾ��ǰ�ڵ������
        //��ʼ��ʱ�����ڵ�������ȶ�����
        priorityQueue.offer(new long[]{0, 0});
        //��Ϊ�Ǵӽڵ�0����������dis[0]=0
        dis[0] = 0;
        ways[0] = 1;

        //��һ���ǵϽ�˹�����㷨�ĺ���,����
        //t����ӽ��0�����ڵ�u�Ļ���
        //u������ǵ�ǰ�ڵ�u
        //dis[u]��ʾ���Ǵӽڵ�0���ڵ�u����Ҫ���ܻ���,��ʼΪ�������
        while (!priorityQueue.isEmpty()) {
            //��Ϊ�����ȶ���,���Զ���ͷһ���Ǿ�����̵�
            long[] arr = priorityQueue.poll();
            long t = arr[0];
            int u = (int) arr[1];
            if (t > dis[u]) {
                continue;
            }
            //������u�ڵ���صı��н��б���
            for (int[] next : e[u]) {
                //v������u���ڵ�ĳ���ڵ�,w��������ڵ�Ļ���
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
