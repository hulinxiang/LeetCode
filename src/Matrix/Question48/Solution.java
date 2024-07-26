package Matrix.Question48;

import java.util.Arrays;

public class Solution {
    /**
     * ��ˮƽ��ת�����ŶԽ��߷�ת���ɵõ�����Ҫ�ľ���
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // �����n���Ǿ���ı߳���������һ��nxn�ľ���
        int n = matrix.length;
        // ����ˮƽ�м��߽��з�ת
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                // ��ʱ�����洢 matrix[i][j]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        // Ȼ��Ҫ���ŶԽ��߽��з�ת
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // ��ʱ�����洢 matrix[i][j]
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
