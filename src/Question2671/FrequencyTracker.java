package Question2671;

public class FrequencyTracker {
    //    ����������ֵ��Χ�޶��� 10^5
    //    ���ڣ�����������Ϊ��ϣ�����Ч���
    private static int[] fre;
    private static int[] recordFre;
    private final int N = 100001;

    //FrequencyTracker()��ʹ��һ���������ʼ�� FrequencyTracker ����
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
