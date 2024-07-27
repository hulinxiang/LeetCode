package HashTable.Question128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int ans = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int cur = i;
                int curLen = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    curLen++;
                }
                ans=Math.max(curLen,ans);
            }
        }
        return ans;

    }
}
