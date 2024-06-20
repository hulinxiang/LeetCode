package Dp.Question2713;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    /**
     * ����Ԫ��ֵ��С������㣬��ô�� i �еı� mat[i][j] С�� f ֵ��������ˣ����ڵ��� mat[i][j] ����δ���㣬���� 0��
     *
     * ���Զ��ڵ� i �У��൱��ȡ��һ�е� f ֵ�����ֵ����Ϊת����Դ��ֵ������ֻ��Ҫ֪����һ�е���� f ֵ�Ƕ��١���ˣ���һ����Ϊ m ������ rowMaxά��ÿһ�е���� f ֵ��
     *
     * ����ÿһ�У�Ҳͬ����һ����Ϊ n ������ colMax ά����
     *
     * @param mat mxn������
     * @return ����ϸ����·���ĳ���
     */
    public int maxIncreasingCells(int[][] mat) {
        // ����
        int m = mat.length;
        // ����
        int n = mat[0].length;
        TreeMap<Integer, List<int[]>> g = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // ����ͬ��Ԫ��ֵ����ͬһ������,ͬһ�������¼ÿ��ֵ��λ��
                g.computeIfAbsent(mat[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        int ans = 0;
        // ����Ǵ��ÿһ�е����ֵ
        int[] rowMax = new int[m];
        // ����Ǵ��ÿһ�е����ֵ
        int[] colMax = new int[n];
        for (List<int[]> pos : g.values()) {
            int[] fs = new int[pos.size()];
            for (int k = 0; k < pos.size(); k++) {
                int[] p = pos.get(k);
                int i = p[0];
                int j = p[1];
                fs[k] = Math.max(rowMax[i], colMax[j]) + 1;
                ans = Math.max(ans, fs[k]);
            }
            for (int k = 0; k < pos.size(); k++) {
                int[] p = pos.get(k);
                int i = p[0];
                int j = p[1];
                // ���µ� i �е���� f ֵ
                rowMax[i] = Math.max(rowMax[i], fs[k]);
                // ���µ� j �е���� f ֵ
                colMax[j] = Math.max(colMax[j], fs[k]);
            }
        }
        return ans;
    }
}
