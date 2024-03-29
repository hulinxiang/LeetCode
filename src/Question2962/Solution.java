package Question2962;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public long countSubarrays(int[] nums, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int max = Arrays.stream(nums).max().getAsInt();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                arrayList.add(i);
            }
        }
        if (arrayList.size() < k) {
            return 0;
        }
        int ans = 0;
        int firstLeft = 0;
        int firstRight = k - 1;
        for (int i = k - 1; i < arrayList.size(); i++) {
            int left = arrayList.get(i - k + 1);
            int right = arrayList.get(i);
            int leftLen = left - firstLeft + 1;
            int rightLen = nums.length - right + 1;
            ans += rightLen * leftLen;
            firstLeft = left;
            firstRight = right;

        }
        return ans;
    }
}
