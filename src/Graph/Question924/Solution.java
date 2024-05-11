package Graph.Question924;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Solution {

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        //�������������ʾ i ������һ����ͨ����
        int[] ids = new int[n];
        Map<Integer, Integer> idToSize = new HashMap<>();
        int id = 0;
        for (int i = 0; i < n; i++) {
            if (ids[i] == 0) {
                //�������0����ô˵����ǰ����ڵ㲻�����κ�һ����ͨ�������ʶ�
                //���ýڵ����һ���µ���ͨ����
                id++;
                int size = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                ids[i] = id;
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int v = 0; v < n; ++v) {
                        if (ids[v] == 0 && graph[u][v] == 1) {
                            ++size;
                            queue.offer(v);
                            ids[v] = id;
                        }
                    }
                }
                idToSize.put(id, size);
            }
        }
        Map<Integer, Integer> idToInitials = new HashMap<>();
        for (int u : initial) {
            idToInitials.put(ids[u], idToInitials.getOrDefault(ids[u], 0) + 1);
        }
        int ans = n + 1, ansRemoved = 0;
        for (int u : initial) {
            //����ø�Ⱦ�ڵ����ڵ���ͨ�������г���һ����Ⱦ�ڵ㣬��ôremoved==0������ͨ�������¼����ͨ�����Ĵ�С�õ����Լ��ٵĸ�Ⱦ����
            //������Ϊ�����ͨ�������в�ֹһ����Ⱦ�ڵ㣬�����������һ����ʣ��ĸ�Ⱦ�ڵ�Ҳ���ʣ�µĽڵ�ȫ������Ⱦ��
            int removed = (idToInitials.get(ids[u]) == 1 ? idToSize.get(ids[u]) : 0);
            if (removed > ansRemoved || (removed == ansRemoved && u < ans)) {
                ans = u;
                ansRemoved = removed;
            }
        }
        return ans;

    }

}
