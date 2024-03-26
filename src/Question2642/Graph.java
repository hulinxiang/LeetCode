package Question2642;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Graph {
    private int[] dist;
    private int[][] graph;
    private int n;

    public Graph(int n, int[][] edges) {
        this.n = n;
        dist = new int[n];
        graph = new int[n][n];
        for (int[] e : graph) {
            Arrays.fill(e, Integer.MAX_VALUE);
        }
        for (int[] e : edges) {
            addEdge(e); // ֱ��ʹ��addEdge������ӱ�
        }


    }

    public void addEdge(int[] edge) {
        int start = edge[0];
        int end = edge[1];
        int cost = edge[2];
        if (graph[start][end] > cost) {
            graph[start][end] = cost;
        }
    }

    //�Ͻ�˹�����㷨
    public int shortestPath(int node1, int node2) {
        //set ����Ѿ�ѡ�еĽڵ�
        Set<Integer> set = new HashSet<>();
        //��ʼ��dist����
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        priorityQueue.offer(new int[]{node1, 0});
        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if (set.contains(currentNode)) {
                continue; // �����ǰ�ڵ��Ѿ����ʹ���������
            }
            set.add(currentNode);

            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (graph[currentNode][nextNode] != Integer.MAX_VALUE && !set.contains(nextNode)) {
                    int nextDist = currentDist + graph[currentNode][nextNode];
                    if (nextDist < dist[nextNode]) {
                        dist[nextNode] = nextDist;
                        priorityQueue.offer(new int[]{nextNode, nextDist}); // �������ȶ���
                    }
                }
            }
        }

        return dist[node2] == Integer.MAX_VALUE ? -1 : dist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
