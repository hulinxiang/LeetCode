package Array.Question45;

public class Solution1 {


    /**
     * Ì°ĞÄËã·¨
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int index = 0;
        int n = nums.length;
        int times = 0;
        int boundary = 0;
        for (int i = 0; i < n - 1; i++) {
            index = Math.max(index, i + nums[i]);
            if (i == boundary) {
                times++;
                boundary = index;
            }
        }
        return times;

    }


}
