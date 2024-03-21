package Question2671;

public class FrequencyTracker {
    //    鉴于所有数值范围限定在 10^5
    //    以内，数组足以作为哈希表的有效替代
    private static int[] fre;
    private static int[] recordFre;
    private final int N = 100001;

    //FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。
    public FrequencyTracker() {
        fre = new int[N];
        recordFre = new int[N];
    }

    public void add(int number) {
        fre[number]++;
        int frequency = fre[number];
        recordFre[frequency]++;
        recordFre[frequency - 1]--;
    }

    public void deleteOne(int number) {
        if (fre[number] > 0) {
            int frequency = fre[number];
            fre[number]--;
            recordFre[frequency]--;
            recordFre[frequency - 1]++;
        }
    }

    public boolean hasFrequency(int frequency) {
        return recordFre[frequency] > 0;
    }
}
