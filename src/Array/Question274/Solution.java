package Array.Question274;

public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] memo = new int[n + 1];
        for (int citation : citations) {
            // 如果大于n个引用，那么我只需要把它当做n个即可
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
