package Question1696;


import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        //动态规划数组
        int[] dp = new int[len];
        //deque中只存放索引，dp值最大的索引在最前面
        Deque<Integer> deque = new LinkedList<>();
        //初始化dp和deque
        dp[0] = nums[0];
        deque.addLast(0);
        for (int i = 1; i < len; i++) {
            //说明第一个元素已经不可能通过一步达到，故而删去
            if(deque.peekFirst()<i-k){
                deque.removeFirst();
            }
            //动态规划方程,第i步的最优解等于本身的值加上前面的最优解
            dp[i]=dp[deque.peekFirst()]+nums[i];
            //当deque数组不为空时,如果deque最后一个元素的花费不比当前元素的花费大,那么可以直接将后面的元素删去,因为i之后的元素就没必要走deque中的其他元素了,走i以得到最优解即可
            while(!deque.isEmpty()&&dp[deque.peekLast()]<=dp[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        return dp[len-1];

    }

    public static void main(String[] args) {
        int[] nums = {1, -1, -2, 4, -7, 3};
        Solution solution = new Solution();
        System.out.println(solution.maxResult(nums, 2));
    }
}


