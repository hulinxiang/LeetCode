package Array.Question274;

public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] memo = new int[n + 1];
        for (int citation : citations) {
            // �������n�����ã���ô��ֻ��Ҫ��������n������
            memo[Math.min(citation, n)]++;
        }
        int count = 0;
        for (int i = n; true; i--) {
            count += memo[i];
            if (count >= i) {
                return i;
            }
        }

    }
}
