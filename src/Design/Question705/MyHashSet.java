package Design.Question705;

class MyHashSet {
    private int[] keys;


    public MyHashSet() {
        keys = new int[1000001];
    }

    public void add(int key) {
        if (keys[key] == 0) {
            keys[key]++;
        }
    }

    public void remove(int key) {
        if (keys[key] == 1) {
            keys[key]--;
        }
    }

    public boolean contains(int key) {
        return keys[key] == 1;
    }
}
