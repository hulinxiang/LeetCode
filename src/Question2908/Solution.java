package Question2908;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minimumSum(int[] nums) {
        PriorityQueue<ArrayList<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int sum1 = 0, sum2 = 0;
                for (int i : o1) {
                    sum1 += i;
                }
                for (int i : o2) {
                    sum2 += i;
                }
                return sum1 - sum2;

            }
        });
        ArrayList<Integer> cur = new ArrayList<>();
        func(nums, cur, priorityQueue, 0);
        int sum = 0;
        if(priorityQueue.isEmpty()){
            return -1;
        }
        for (int i : priorityQueue.poll()) {
            sum += i;
        }
        return sum;


    }


    public void func(int[] nums, ArrayList<Integer> cur, PriorityQueue<ArrayList<Integer>> priorityQueue, int index) {
        if (cur.size() == 3) {
            ArrayList<Integer> tmp = new ArrayList<>(cur);
            priorityQueue.offer(tmp);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (cur.size() == 0) {
                cur.add(nums[i]);
                func(nums, cur, priorityQueue, i + 1);
                cur.remove(0);
            }
            else if (cur.size() == 1) {
                if (nums[i] <= cur.get(0)) {
                    continue;
                }
                cur.add(nums[i]);
                func(nums, cur, priorityQueue, i + 1);
                cur.remove(1);
            }
            else if (cur.size() == 2) {
                if (nums[i] >= cur.get(1)) {
                    continue;
                }
                cur.add(nums[i]);
                func(nums, cur, priorityQueue, i + 1);
                cur.remove(2);
            }
        }

    }


    public static void main(String[] args) {
        int[] num = new int[]{8, 6, 1, 5, 3};
        System.out.println(new Solution().minimumSum(num));
    }

}
