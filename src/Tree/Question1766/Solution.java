package Tree.Question1766;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    //因为数据都是小于51的,所以可以直接存储51所有以内所以互质的数
    private static final int MX = 51;
    private static final int[][] coprime = new int[MX][MX];

    static {
        //预处理
        //coprime[i] 保存[1,MX]中与i互质的所有元素
        for (int i = 1; i < MX; i++) {
            int k = 0;
            for (int j = 1; j < MX; j++) {
                if (gcd(i, j) == 1) {
                    coprime[i][k++] = j;
                }
            }
        }


    }

    //返回a,b两个数的最大公约数
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        //构建邻接表
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
        //x的节点值, x代表当前的节点index, fa 代表其父节点的index
        int val = nums[x];

        //计算与val互质的祖先节点值中,节点深度最大的节点编号
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

        // tmpDepth 和 tmpNodeId 用于恢复现场
        int tmpDepth = valDepth[val];
        int tmpNodeId = valNodeId[val];

        // 保存val对应的节点深度和节点编号
        valDepth[val] = depth;
        valNodeId[val] = x;

        for (int y : g[x]) {
            if (y != fa) {
                dfs(y, x, depth + 1, g, nums, ans, valDepth, valNodeId);
            }
        }

        //恢复现场
        valDepth[val] = tmpDepth;
        valNodeId[val] = tmpNodeId;

    }
}
