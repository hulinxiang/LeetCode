package Dp.Question1997;

class Solution {
    //如果算上本次访问，访问 i 号房间的次数为 奇数 ，那么 第二天 需要访问 nextVisit[i] 所指定的房间，其中 0 <= nextVisit[i] <= i
    //如果算上本次访问，访问 i 号房间的次数为 偶数 ，那么 第二天 需要访问 (i + 1) mod n 号房间。
    //首先根据观察，如果想要往右边走，实现所有元素的遍历，那么就需要前面第n次的都是偶数才可以

    /**
     * 动态规划
     *
     * @param nextVisit 一个充满了房间编号的数组
     * @return 所有房间都完成了一次遍历时候的天数。天数从0开始递增
     */
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int mod = 1_000_000_007;
        //n 代表有多少住户
        int n = nextVisit.length;
        //动态规划数组
        //如果dp[x]等于0,那么需要先访问一次x，这样x的值等于1了，然后再回访一次，这样再访问x的值就是2，为偶数了
        long[] dp = new long[n];
        for (int i = 0; i < n - 1; i++) {
            dp[i + 1] = (dp[i] + 1 + dp[i] - dp[nextVisit[i]] + 1 + mod) % mod;
        }

        return (int) dp[n - 1];

    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstDayBeenInAllRooms(new int[]{0, 0, 2}));
    }
}
