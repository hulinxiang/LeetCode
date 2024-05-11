package Graph.Question924;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Solution {

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        //这个变量用来表示 i 属于哪一个连通分量
        int[] ids = new int[n];
        Map<Integer, Integer> idToSize = new HashMap<>();
        int id = 0;
        for (int i = 0; i < n; i++) {
            if (ids[i] == 0) {
                //如果等于0，那么说明当前这个节点不属于任何一个连通分量，故而
                //给该节点分配一个新的连通分量
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
            //如果该感染节点所在的连通分量中有超过一个感染节点，那么removed==0，否则通过上面记录的连通分量的大小得到可以减少的感染数；
            //这是因为这个连通分量中有不止一个感染节点，哪怕溢出了这一个，剩余的感染节点也会把剩下的节点全部都感染完
            int removed = (idToInitials.get(ids[u]) == 1 ? idToSize.get(ids[u]) : 0);
            if (removed > ansRemoved || (removed == ansRemoved && u < ans)) {
                ans = u;
                ansRemoved = removed;
            }
        }
        return ans;

    }

}
