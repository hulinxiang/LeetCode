package Sort.Question912;

import java.util.Arrays;

public class Solution {
    public int[] sortArray(int[] nums) {
        QuickSort(nums,0,nums.length-1);
        return nums;
    }

    private void QuickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotPos = Partition(nums, low, high);
            QuickSort(nums, low, pivotPos - 1);
            QuickSort(nums, pivotPos + 1, high);
        }


    }

    private int Partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                --high;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                ++low;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }
}
