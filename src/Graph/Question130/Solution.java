package Graph.Question130;

public class Solution {
    int[] fa;

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int mn = m * n; // 虚拟节点索引
        fa = new int[mn + 1];  // 并查集父节点数组

        // 初始化父节点数组
        for (int i = 0; i <= mn; i++) {
            fa[i] = i;
        }

        // 遍历整个矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    // 如果是边界上的'O'，连接到虚拟节点mn
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        merge(i * n + j, mn);  // 将边界'O'连接到虚拟节点
                    } else {
                        // 向四个方向合并
                        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                        for (int[] dir : directions) {
                            int x = i + dir[0];
                            int y = j + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                                merge(i * n + j, x * n + y);
                            }
                        }
                    }
                }
            }
        }

        // 最后遍历所有'O'，如果它们没有连接到虚拟节点mn，说明它们被围住了，改为'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && find(i * n + j) != find(mn)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // 查找操作，路径压缩
    public int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    // 合并操作
    public void merge(int f, int to) {
        f = find(f);
        to = find(to);
        if (f != to) {
            fa[f] = to;
        }
    }
}
