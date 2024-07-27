package HashTable.Question290;

import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        char[] chars = pattern.toCharArray();
        HashMap<Character, String> hashMap = new HashMap<>();
        if (ss.length != chars.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.get(chars[i]) == null && !hashMap.containsValue(ss[i])) {
                hashMap.put(chars[i], ss[i]);
            }
            if (hashMap.get(chars[i]) == null && hashMap.containsValue(ss[i])) {
                return false;
            } else {
                if (!hashMap.get(chars[i]).equals(ss[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
