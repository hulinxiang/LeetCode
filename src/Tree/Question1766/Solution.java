package Tree.Question1766;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    //��Ϊ���ݶ���С��51��,���Կ���ֱ�Ӵ洢51�����������Ի��ʵ���
    private static final int MX = 51;
    private static final int[][] coprime = new int[MX][MX];

    static {
        //Ԥ����
        //coprime[i] ����[1,MX]����i���ʵ�����Ԫ��
        for (int i = 1; i < MX; i++) {
            int k = 0;
            for (int j = 1; j < MX; j++) {
                if (gcd(i, j) == 1) {
                    coprime[i][k++] = j;
                }
            }
        }


    }

    //����a,b�����������Լ��
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        //�����ڽӱ�
        for (int[] e : edges) {
            int first = e[0];
            int second = e[1];
            g[first].add(second);
            g[second].add(first);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int[] valDepth = new int[MX];
        int[] valNodeId = new int[MX];
        dfs(0, -1, 1, g, nums, ans, valDepth, valNodeId);
        return ans;

    }


    private void dfs(int x, int fa, int depth, List<Integer>[] g, int[] nums, int[] ans, int[] valDepth, int[] valNodeId) {
        //x�Ľڵ�ֵ, x����ǰ�Ľڵ�index, fa �����丸�ڵ��index
        int val = nums[x];

        //������val���ʵ����Ƚڵ�ֵ��,�ڵ�������Ľڵ���
        int maxDepth = 0;
        for (int j : coprime[val]) {
            if (j == 0) {
                break;
            }
            if (valDepth[j] > maxDepth) {
                maxDepth = valDepth[j];
                ans[x] = valNodeId[j];
            }
        }

        // tmpDepth �� tmpNodeId ���ڻָ��ֳ�
        int tmpDepth = valDepth[val];
        int tmpNodeId = valNodeId[val];

        // ����val��Ӧ�Ľڵ���Ⱥͽڵ���
        valDepth[val] = depth;
        valNodeId[val] = x;

        for (int y : g[x]) {
            if (y != fa) {
                dfs(y, x, depth + 1, g, nums, ans, valDepth, valNodeId);
            }
        }

        //�ָ��ֳ�
        valDepth[val] = tmpDepth;
        valNodeId[val] = tmpNodeId;

    }
}
