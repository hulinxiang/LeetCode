package Graph.Question210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // ����ͼ
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            graph[pre[0]].add(pre[1]); // ע�⣺����ķ����� pre[0] -> pre[1]
        }

        // ���ڴ洢�γ�˳��
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[numCourses]; // ��¼�ڵ��Ƿ񱻷��ʹ�
        boolean[] onStack = new boolean[numCourses]; // ��¼��ǰ�ݹ�ջ�еĽڵ�

        // ��ÿ��δ���ʵĽڵ����DFS
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(graph, i, visited, onStack, order)) {
                    return new int[0]; // ���ֻ������ؿ�����
                }
            }
        }

        // ��˳���б�ת��Ϊ����
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }
        return result;
    }

    // DFS���������ڼ�⻷�������γ�˳��
    private boolean hasCycle(List<Integer>[] graph, int cur, boolean[] visited, boolean[] onStack, List<Integer> order) {
        if (onStack[cur]) {
            return true; // ���ֻ�
        }
        if (visited[cur]) {
            return false; // �Ѿ����ʹ������ٴ���
        }

        visited[cur] = true; // ��ǵ�ǰ�ڵ�Ϊ�ѷ���
        onStack[cur] = true; // ����ǰ�ڵ����ݹ�ջ

        // ������ǰ�ڵ�������ھ�
        for (int neighbor : graph[cur]) {
            if (hasCycle(graph, neighbor, visited, onStack, order)) {
                return true; // ���ھӵ�DFS�з��ֻ�
            }
        }

        onStack[cur] = false; // ����ǰ�ڵ��Ƴ��ݹ�ջ
        order.add(cur); // ����ǰ�ڵ����γ�˳��
        return false; // û�з��ֻ�
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result = solution.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(result)); // ���: [0, 1, 2, 3]
    }
}