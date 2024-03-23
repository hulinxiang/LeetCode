package Question2617;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minimumVisitedCells(int[][] grid) {
        //m:���� n:����
        int m = grid.length;
        int n = grid[0].length;
        int f = 0;
        PriorityQueue<int[]>[] colHeaps = new PriorityQueue[n];
        //colHeaps ��Ϊÿһ�е���С�ѣ��������ȶ�������ŵ������飬�����е�һ��Ԫ�ش�����һ�е������������еڶ���Ԫ�ش���g+i
        Arrays.setAll(colHeaps, i -> new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0])));
        PriorityQueue<int[]> rowH = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < m; i++) {
            rowH.clear();
            for (int j = 0; j < n; j++) {
                //�޷������j��
                while (!rowH.isEmpty() && rowH.peek()[1] < j) {
                    rowH.poll();
                }
                PriorityQueue<int[]> colH = colHeaps[j];
                //�޷������i��
                while (!colH.isEmpty() && colH.peek()[1] < i) {
                    colH.poll();
                }

                f = i > 0 || j > 0 ? Integer.MAX_VALUE : 1;
                if (!rowH.isEmpty()) {
                    //�����������
                    f = rowH.peek()[0] + 1;
                }
                if (!colH.isEmpty()) {
                    //���ϱ�������
                    f = Math.min(f, colH.peek()[0] + 1);
                }

                int g = grid[i][j];
                if (g > 0 && f < Integer.MAX_VALUE) {
                    rowH.offer(new int[]{f, g + j});// �����ĸ�������������Զ�ܵ�����к�
                    colH.offer(new int[]{f, g + i}); // �����ĸ�������������Զ�ܵ�����к�
                }
            }
        }

        return f < Integer.MAX_VALUE ? f : -1; // ��ʱ�� f ���� (m-1, n-1) ���������
    }


}
