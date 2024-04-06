package GreedyAlgorithm.Question2952;

import java.util.Arrays;

/**
 * 把 coins\textit{coins}coins 从小到大排序，遍历 x=coins[i]x=\textit{coins}[i]x=coins[i]。分类讨论，看是否要添加数字：
 * 如果 x≤sx \le sx≤s，那么合并 [0,s−1][0,s-1][0,s−1] 和 [x,s+x−1][x,s+x-1][x,s+x−1] 这两个区间，我们可以得到 [0,s+x−1][0,s+x-1][0,s+x−1] 中的所有整数。
 * 如果 x>sx > sx>s，或者遍历完了 coins\textit{coins}coins 数组，这意味着我们无法得到 sss，那么就一定要把 sss 加到数组中（加一个比 sss 还小的数字就没法得到更大的数，不够贪），这样就可以得到了 [s,2s−1][s,2s-1][s,2s−1] 中的所有整数，再与 [0,s−1][0,s-1][0,s−1] 合并，可以得到 [0,2s−1][0,2s-1][0,2s−1] 中的所有整数。然后再考虑 xxx 和 2s2s2s 的大小关系，继续分类讨论。
 * 当 s>targets > \textit{target}s>target 时，我们就得到了 [1,target][1,target][1,target] 中的所有整数，退出循环。
 *
 */
class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        //First sort the array
        Arrays.sort(coins);
        int ans=0,s=1,i=0;
        while(s<=target){
            if(i<coins.length&&coins[i]<=s){
                s+=coins[i++];
            }else {
                s*=2;
                ans++;
            }
        }
        return ans;
    }
}