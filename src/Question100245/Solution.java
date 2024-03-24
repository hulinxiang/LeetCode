package Question100245;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>(26);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        l1:
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length()) {
                if (!hashMap.containsKey(s.charAt(j))) {
                    hashMap.put(s.charAt(j), 1);
                } else {
                    if (hashMap.get(s.charAt(j)) != 2) {
                        hashMap.replace(s.charAt(j), 1, 2);
                    } else {
                        priorityQueue.add(j - i);
                        hashMap.clear();
                        continue l1;
                    }
                }
                j++;
            }
            priorityQueue.add(j - i);
            hashMap.clear();
        }
        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        String s = "bcbbbcba";
        System.out.println(new Solution().maximumLengthSubstring(s));
    }
}