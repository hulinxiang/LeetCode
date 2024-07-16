package Array.Question380;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
public class RandomizedSet {
    // ������ε�ֵ��ֵ��ʹ���˵�����index
    Map<Integer, Integer> map;
    int[] arr = new int[200000];
    int idx;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        idx = -1;
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            arr[++idx] = val;
            map.put(val, idx);
            return true;
        }
    }

    public boolean remove(int val) {
        // �����ϣ������û�����val�Ǿ�˵��û�����ֵ��ֱ�ӷ���false
        if (!map.containsKey(val)) {
            return false;
        }
        int loc = map.remove(val);
        if (loc != idx) {
            map.put(arr[idx], loc);
        }
        arr[loc] = arr[idx--];
        return true;
    }

    public int getRandom() {
        return arr[random.nextInt(idx + 1)];
    }
}
