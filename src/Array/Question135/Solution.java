package Array.Question135;

import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        //        ��ȷ���ұ����ִ�����ߵ������Ҳ���Ǵ�ǰ��������
        //
        //        ��ʱ�ֲ����ţ�ֻҪ�ұ����ֱ���ߴ��ұߵĺ��ӾͶ�һ���ǹ���ȫ�����ţ����ڵĺ����У����ָߵ��Һ��ӻ�ñ���ߺ��Ӹ�����ǹ�
        //
        //        �ֲ����ſ����Ƴ�ȫ�����š�
        //        ��ȷ�����Ӵ����Һ��ӵ�������Ӻ���ǰ������
        //
        //        ����˳��������ͬѧ���ܻ������ʣ�Ϊʲô���ܴ�ǰ�������أ�
        //
        //        ��Ϊ rating[5]��rating[4]�ıȽ� Ҫ������ rating[5]��rating[6]�ıȽϽ�������� Ҫ�Ӻ���ǰ������
        //
        //        �����ǰ��������rating[5]��rating[4]�ıȽ� �Ͳ������� rating[5]��rating[6]�ıȽϽ����
        int[] res = new int[n];
        Arrays.fill(res, 1);
        //�������ҽ���һ��̰���㷨
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int j = n - 1; j > 0; j--) {
            if (ratings[j] < ratings[j - 1]) {
                res[j - 1] = Math.max(res[j] + 1,res[j-1]);
            }
        }
        return Arrays.stream(res).sum();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1, 3, 4, 5, 2}));
    }
}
