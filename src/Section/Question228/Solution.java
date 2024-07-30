package Section.Question228;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int pointer1 = 0;
        int pointer2 = 1;
        int len = nums.length;
        List<String> ans = new ArrayList<>();
        if (len == 0) {
            return ans;
        }
        int cur = nums[0];
        while (pointer2 < len) {
            if (nums[pointer2] == cur + 1) {
                cur = nums[pointer2++];
            } else {
                ans.add(buildString(nums[pointer1], nums[pointer2 - 1]));
                pointer1 = pointer2;
                pointer2 = pointer2 + 1;
                cur = nums[pointer1];
            }
        }
        ans.add(buildString(nums[pointer1], nums[pointer2 - 1]));

        return ans;
    }

    private String buildString(int a, int b) {
        StringBuilder stringBuilder = new StringBuilder();
        if (a == b) {
            return stringBuilder.append(a).toString();
        }
        stringBuilder.append(a).append("->").append(b);
        return stringBuilder.toString();
    }

}
