package LCP.LCP61;

public class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int[] trendA = new int[n - 1];
        int[] trendB = new int[n - 1];
        for (int i = 1; i < n; i++) {
            PRE(temperatureA, trendA, i);
            PRE(temperatureB, trendB, i);
        }
        int ans = 0;
        int cur=0;
        for (int i = 0; i < n - 1; i++) {
            if (trendA[i] == trendB[i]) {
                  cur++;
            }else {
                ans=Math.max(ans,cur);
                cur=0;
            }
        }
        ans=Math.max(ans,cur);
        return ans;
    }

    private void PRE(int[] temperature, int[] trend, int i) {
        if (temperature[i] > temperature[i - 1]) {
            trend[i - 1] = 1;
        } else if (temperature[i] == temperature[i - 1]) {
            trend[i - 1] = 0;
        } else if (temperature[i] < temperature[i - 1]) {
            trend[i - 1] = -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().temperatureTrend(new int[]{21,18,18,18,31},new int[]{34,32,16,16,17}));
    }


}
