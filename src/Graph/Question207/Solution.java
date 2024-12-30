package Graph.Question207;

import java.util.ArrayList;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // 构建图
        for (int[] pre : prerequisites) {
            graph[pre[0]].add(pre[1]);
        }

        // 检测图中是否有环，如果有环则无法完成所有课程
        return !detectCycle(graph);
    }

    // 检测图中是否有环
    public boolean detectCycle(ArrayList<Integer>[] graph) {
        int numNodes = graph.length;
        boolean[] visited = new boolean[numNodes]; // 记录节点是否被访问过
        boolean[] recStack = new boolean[numNodes]; // 记录当前递归栈中的节点

        // 对每个未访问的节点进行DFS
        for (int i = 0; i < numNodes; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, recStack)) {
                    return true; // 发现环
                }
            }
        }
        return false; // 没有发现环
    }

    // DFS函数，用于递归检测环
    private boolean dfs(ArrayList<Integer>[] graph, int current, boolean[] visited, boolean[] recStack) {
        if (recStack[current]) {
            return true; // 发现当前节点已经在递归栈中，说明有环
        }
        if (visited[current]) {
            return false; // 当前节点已经被访问过，但不在递归栈中，说明没有环
        }

        visited[current] = true; // 标记当前节点为已访问
        recStack[current] = true; // 将当前节点加入递归栈

        // 遍历当前节点的所有邻居
        for (int neighbor : graph[current]) {
            if (dfs(graph, neighbor, visited, recStack)) {
                return true; // 在邻居的DFS中发现环
            }
        }

        recStack[current] = false; // 将当前节点移出递归栈
        return false; // 没有发现环
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(solution.canFinish(numCourses, prerequisites)); // 输出: false
    }
}