package Matrix.Question289;

public class Solution {
    int n;
    int m;

    public void gameOfLife(int[][] board) {
//        如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
//        如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
//        如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
//        如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
        n = board.length;
        m = board[0].length;
        int[][] boards = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (m >= 0) {
                System.arraycopy(board[i], 0, boards[i], 0, m);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = countLiveNeighbors(boards, i, j);
                int cur = boards[i][j];
                if (cur == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }

    }

    private int countLiveNeighbors(int[][] board, int row, int column) {
        int count = 0;
        int rowStart = Math.max(0, row - 1);
        int rowEnd = Math.min(row + 1, n - 1);
        int colStart = Math.max(0, column - 1);
        int colEnd = Math.min(column + 1, m - 1);
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (board[i][j] == 1) {
                    count++;
                }
            }
        }
        if (board[row][column] == 1) {
            count--;
        }
        return count;

    }


}
