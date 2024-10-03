package HashTable.Question49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = hashMap.getOrDefault(key, new ArrayList<>());
            list.add(s);
            hashMap.put(key, list);
        }
        return new ArrayList<>(hashMap.values());
    }
}