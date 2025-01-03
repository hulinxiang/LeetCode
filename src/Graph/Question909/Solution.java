package Graph.Question909;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        // ��ʼ���������е�һ��������id�������еڶ����������ߵĲ���
        queue.add(new int[]{1, 0});
        // ͼ�Ĳ�α����ľ���ṹ
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            // ����ɸ��Ͷ��
            for (int i = 1; i <= 6; i++) {
                int nxt = p[0] + i;
                if (nxt > n * n) {
                    break;
                }
                // �õ���һ��������
                int[] rc = id2rc(nxt, n);
                if (board[rc[0]][rc[1]] != -1) {
                    nxt = board[rc[0]][rc[1]];
                }
                //�����յ�
                if (nxt == n * n) {
                    return p[1] + 1;
                }
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    // ��[��ǰ�Ľ��ı��,�Ѿ��ߵĲ���]ѹ�������
                    queue.offer(new int[]{nxt, p[1] + 1});
                }
            }
        }
        return -1;
    }

    public int[] id2rc(int id, int n) {
        int row = (id - 1) / n;
        int col = (id - 1) % n;
        if (row % 2 == 1) {
            col = n - 1 - col;
        }
        return new int[]{n - 1 - row, col};
    }
}
