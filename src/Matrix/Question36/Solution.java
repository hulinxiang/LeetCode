package Matrix.Question36;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] subBoxes = new int[3][3][9];
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Character.isDigit(board[i][j])) {
                    int cur = board[i][j] - '0' - 1;
                    rows[i][cur]++;
                    cols[j][cur]++;
                    int subCol = i / 3;
                    int subRow = j / 3;
                    subBoxes[subRow][subCol][cur]++;
                    if (rows[i][cur] > 1 || subBoxes[subRow][subCol][cur] > 1 || cols[j][cur]++ > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(new Solution().isValidSudoku(board));
    }
}
