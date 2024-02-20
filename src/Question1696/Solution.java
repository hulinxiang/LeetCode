package Question1696;


import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        //��̬�滮����
        int[] dp = new int[len];
        //deque��ֻ���������dpֵ������������ǰ��
        Deque<Integer> deque = new LinkedList<>();
        //��ʼ��dp��deque
        dp[0] = nums[0];
        deque.addLast(0);
        for (int i = 1; i < len; i++) {
            //˵����һ��Ԫ���Ѿ�������ͨ��һ���ﵽ���ʶ�ɾȥ
            if(deque.peekFirst()<i-k){
                deque.removeFirst();
            }
            //��̬�滮����,��i�������Ž���ڱ����ֵ����ǰ������Ž�
            dp[i]=dp[deque.peekFirst()]+nums[i];
            //��deque���鲻Ϊ��ʱ,���deque���һ��Ԫ�صĻ��Ѳ��ȵ�ǰԪ�صĻ��Ѵ�,��ô����ֱ�ӽ������Ԫ��ɾȥ,��Ϊi֮���Ԫ�ؾ�û��Ҫ��deque�е�����Ԫ����,��i�Եõ����Ž⼴��
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


