package Question2673;

public class Solution {
    /**
     * ��̰���㷨,������β�˿�ʼ,��Ϊindex�Ǵ�0��ʼ��,���������һ��Ҷ�ӽڵ�i��ʼ����ô����
     * ���ֵ�Ϊi-1,���ĸ��ڵ�Ϊ(i-1)/2,ÿ��ѭ��i-=2
     */
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n - 1; i > 0; i -= 2) {
            ans += Math.abs(cost[i] - cost[i - 1]);
            cost[(i - 1) / 2] += Math.max(cost[i], cost[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 2, 3, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.minIncrements(7, nums));
    }
}
