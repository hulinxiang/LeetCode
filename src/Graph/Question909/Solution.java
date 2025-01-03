package Graph.Question909;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        // 初始化，数组中第一个数代表id，数组中第二个数代表走的步数
        queue.add(new int[]{1, 0});
        // 图的层次遍历的经典结构
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            // 六面筛子投掷
            for (int i = 1; i <= 6; i++) {
                int nxt = p[0] + i;
                if (nxt > n * n) {
                    break;
                }
                // 得到下一步的行列
                int[] rc = id2rc(nxt, n);
                if (board[rc[0]][rc[1]] != -1) {
                    nxt = board[rc[0]][rc[1]];
                }
                //到达终点
                if (nxt == n * n) {
                    return p[1] + 1;
                }
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    // 把[当前的结点的编号,已经走的步数]压入队列中
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
