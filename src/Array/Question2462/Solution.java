package Array.Question2462;


import java.util.PriorityQueue;


public class Solution {

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        // ����o1, o2�ĵ�һ��Ԫ��������С��������
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[0] > o2[0] ? 1 : o1[0] == o2[0] ? o1[1] - o2[1] : -1));
        //left��right�Ŀ�ʼλ��
        int left = candidates - 1, right = n - candidates;
        if (left >= right - 1) {
            //��ʱ���Ѿ���������Ԫ���ˣ���ȫ������
            for (int i = 0; i < n; i++) {
                pq.add(new int[]{costs[i], i});
            }
        } else {
            for (int i = 0; i < candidates; i++) {
                pq.add(new int[]{costs[i], i});
            }
            for (int j = 0; j < candidates; j++) {
                pq.add(new int[]{costs[n - 1 - j], n - 1 - j});
            }
        }
        long res = 0;
        for (int l = 0; l < k; l++) {
            int[] min = pq.poll();
            res += min[0];
            if (left < right - 1) {
                if (min[1] <= left) {
                    ++left;
                    pq.add(new int[]{costs[left], left});
                } else {
                    --right;
                    pq.add(new int[]{costs[right], right});
                }
            }
        }
        return res;

    }
}
