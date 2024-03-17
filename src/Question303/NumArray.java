package Question303;

class NumArray {
    private int[] arr;


    public NumArray(int[] nums) {
        arr = new int[nums.length + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = nums[i - 1] + arr[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return arr[right + 1] - arr[left];
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        System.out.println(new NumArray(arr).sumRange(0, 2));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */