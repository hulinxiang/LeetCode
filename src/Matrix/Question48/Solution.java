package Matrix.Question48;

import java.util.Arrays;

public class Solution {
    /**
     * 先水平翻转再沿着对角线翻转即可得到所需要的矩阵
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // 这里的n就是矩阵的边长，矩阵是一个nxn的矩阵
        int n = matrix.length;
        // 沿着水平中间线进行翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                // 临时变量存储 matrix[i][j]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        // 然后要沿着对角线进行翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 临时变量存储 matrix[i][j]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


    }


    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().rotate(ints);
        System.out.println(Arrays.deepToString(ints));
    }

}
