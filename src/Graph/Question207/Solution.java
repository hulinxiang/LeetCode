package Graph.Question207;

import java.util.ArrayList;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // ����ͼ
        for (int[] pre : prerequisites) {
            graph[pre[0]].add(pre[1]);
        }

        // ���ͼ���Ƿ��л�������л����޷�������пγ�
        return !detectCycle(graph);
    }

    // ���ͼ���Ƿ��л�
    public boolean detectCycle(ArrayList<Integer>[] graph) {
        int numNodes = graph.length;
        boolean[] visited = new boolean[numNodes]; // ��¼�ڵ��Ƿ񱻷��ʹ�
        boolean[] recStack = new boolean[numNodes]; // ��¼��ǰ�ݹ�ջ�еĽڵ�

        // ��ÿ��δ���ʵĽڵ����DFS
        for (int i = 0; i < numNodes; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, recStack)) {
                    return true; // ���ֻ�
                }
            }
        }
        return false; // û�з��ֻ�
    }

    // DFS���������ڵݹ��⻷
    private boolean dfs(ArrayList<Integer>[] graph, int current, boolean[] visited, boolean[] recStack) {
        if (recStack[current]) {
            return true; // ���ֵ�ǰ�ڵ��Ѿ��ڵݹ�ջ�У�˵���л�
        }
        if (visited[current]) {
            return false; // ��ǰ�ڵ��Ѿ������ʹ��������ڵݹ�ջ�У�˵��û�л�
        }

        visited[current] = true; // ��ǵ�ǰ�ڵ�Ϊ�ѷ���
        recStack[current] = true; // ����ǰ�ڵ����ݹ�ջ

        // ������ǰ�ڵ�������ھ�
        for (int neighbor : graph[current]) {
            if (dfs(graph, neighbor, visited, recStack)) {
                return true; // ���ھӵ�DFS�з��ֻ�
            }
        }

        recStack[current] = false; // ����ǰ�ڵ��Ƴ��ݹ�ջ
        return false; // û�з��ֻ�
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(solution.canFinish(numCourses, prerequisites)); // ���: false
    }
}