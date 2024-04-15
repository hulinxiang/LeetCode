package Design.Question706;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyHashMap {
    private static final int BASE = 769;
    private List<int[]>[] data;

    //³õÊ¼»¯
    public MyHashMap() {
        data = new ArrayList[BASE];
        Arrays.setAll(data, i -> new ArrayList<>());
    }

    public void put(int key, int value) {
        int h = hash(key);
        for (int i = 0; i < data[h].size(); i++) {
            if (key == data[h].get(i)[0]) {
                data[h].get(i)[1] = value;
                return;
            }
        }
        data[h].add(new int[]{key, value});

    }

    public int get(int key) {
        int h = hash(key);
        for (int i = 0; i < data[h].size(); i++) {
            if (key == data[h].get(i)[0]) {
                return data[h].get(i)[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        for (int i = 0; i < data[h].size(); i++) {
            if (key == data[h].get(i)[0]) {
                data[h].remove(i);
                return;
            }
        }
    }

    public int hash(int key) {
        return key % BASE;
    }

}
