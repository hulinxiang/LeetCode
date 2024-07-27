package HashTable.Question205;

import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        for (int i = 0; i < arrS.length; i++) {
            char curS = arrS[i];
            char curT = arrT[i];
            if (!hashMap.containsKey(curS) && !hashMap.containsValue(curT)) {
                hashMap.put(arrS[i], arrT[i]);
            }
            if (!hashMap.containsKey(curS) && hashMap.containsValue(curT)){
                return false;
            }else {
                if (curT != hashMap.get(curS)) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("paper", "title"));
    }
}
