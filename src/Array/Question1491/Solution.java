package Array.Question1491;

import java.util.Arrays;

public class Solution {
    public double average(int[] salary) {
        int max = Arrays.stream(salary).max().getAsInt();
        int min = Arrays.stream(salary).min().getAsInt();
        int sum = Arrays.stream(salary).sum();
        return (double) (sum-max-min) / (salary.length - 2);
    }

    public static void main(String[] args) {
        int[] n=new int[]{4000,3000,1000,2000};
        System.out.println(new Solution().average(n));
    }
}
