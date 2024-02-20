package Question239;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * PriorityQueue类提供堆数据结构的功能。
 * 我们可以重写compare()方法。该方法现在使元素的头成为最大的数，从而实现大根堆。
 */

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        //将前k个元素加入优先队列
        for (int i = 0; i < k; i++) {
            priorityQueue.add(new int[]{nums[i], i});
        }

        //要返回的数组
        int[] ans = new int[len - k + 1];
        assert priorityQueue.peek() != null;
        ans[0] = priorityQueue.peek()[0];
        for (int i = k; i < len; i++) {
            priorityQueue.add(new int[]{nums[i], i});
            assert priorityQueue.peek() != null;
            while(true){
                assert priorityQueue.peek() != null;
                if (!(priorityQueue.peek()[1]< i - k + 1)) {
                    break;
                }
                priorityQueue.remove();
            }
            assert priorityQueue.peek() != null;
            ans[i - k + 1] = priorityQueue.peek()[0];
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] ints = {9,10,9,-7,-4,-8,2,-6};
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(ints, 5)));
    }
}
