package SlidingWindow.Question76;

public class Solution {
    public String minWindow(String s, String t) {
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        int left = 0;
        char[] S = s.toCharArray();
        int ansLeft = -1;
        int n = s.length();
        int ansRight = n;
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }
        for (int right = 0; right < n; right++) {
            cntS[s.charAt(right)]++;
            while (ifCovered(cntS, cntT)) {
                if (right - left < ansRight - ansLeft) {
                    ansRight = right;
                    ansLeft = left;
                }
                cntS[S[left++]]--;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);

    }

    private boolean ifCovered(int[] cntS, int[] cntT) {
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }


}
