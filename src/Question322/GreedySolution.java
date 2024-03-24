package Question322;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 基于贪心算法求解，逻辑已经没问题了，但是本题不太适合贪心算法，虽然可以优化，但是还是更适合用动态规划求解
 *
 * @author Hu
 */
public class GreedySolution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int sum = 0;
        int[] records = new int[coins.length];
        while (sum < amount) {
            sum += coins[coins.length - 1];
            records[coins.length - 1]++;
        }
        if (sum == amount) {
            return Arrays.stream(records).sum();
        }
        boolean[] ifFind = new boolean[1];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Arrays.stream(a).sum() - Arrays.stream(b).sum());
        coinNumber(coins, coins.length - 1, amount, records, sum, ifFind, priorityQueue);
        if (!ifFind[0]) {
            return -1;
        }
        return Arrays.stream(priorityQueue.poll()).sum();
    }

    /**
     * 用贪心算法，尝试不断地加入最大数额的金币
     */
    public void coinNumber(int[] coins, int curIndex, int amount, int[] records, int sum, boolean[] ifFind, PriorityQueue<int[]> priorityQueue) {
        //注意默认进入递归的时候，sum的值是大于等于了amount的
        if (sum == amount || curIndex == 0) {
            return;
        }
        while (records[curIndex] > 0) {
            //清除掉递归的缓存
            if (records[0] != 0) {
                records[0] = 0;
            }
            records[curIndex]--;
            sum = calculate(coins, records);
            while (sum < amount) {
                sum += coins[curIndex - 1];
                records[curIndex - 1]++;
            }
            if (sum == amount) {
                ifFind[0] = true;
                int[] recordsCopy = Arrays.copyOf(records, records.length);
                priorityQueue.add(recordsCopy);
            }
            coinNumber(coins, curIndex - 1, amount, records, sum, ifFind, priorityQueue);
        }

    }

    private int calculate(int[] coins, int[] records) {
        int ans = 0;
        for (int i = 0; i < records.length; i++) {
            if (records[i] != 0) {
                ans += records[i] * coins[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] coins = {3, 7, 405, 436};
        int amount = 8839;
        System.out.println(new GreedySolution().coinChange(coins, amount));
    }

}
