package Graph.Question210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 构建图
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            graph[pre[0]].add(pre[1]); // 注意：这里的方向是 pre[0] -> pre[1]
        }

        // 用于存储课程顺序
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[numCourses]; // 记录节点是否被访问过
        boolean[] onStack = new boolean[numCourses]; // 记录当前递归栈中的节点

        // 对每个未访问的节点进行DFS
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(graph, i, visited, onStack, order)) {
                    return new int[0]; // 发现环，返回空数组
                }
            }
        }

        // 将顺序列表转换为数组
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }
        return result;
    }

    // DFS函数，用于检测环并构建课程顺序
    private boolean hasCycle(List<Integer>[] graph, int cur, boolean[] visited, boolean[] onStack, List<Integer> order) {
        if (onStack[cur]) {
            return true; // 发现环
        }
        if (visited[cur]) {
            return false; // 已经访问过，不再处理
        }

        visited[cur] = true; // 标记当前节点为已访问
        onStack[cur] = true; // 将当前节点加入递归栈

        // 遍历当前节点的所有邻居
        for (int neighbor : graph[cur]) {
            if (hasCycle(graph, neighbor, visited, onStack, order)) {
                return true; // 在邻居的DFS中发现环
            }
        }

        onStack[cur] = false; // 将当前节点移出递归栈
        order.add(cur); // 将当前节点加入课程顺序
        return false; // 没有发现环
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result = solution.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(result)); // 输出: [0, 1, 2, 3]
    }
}