package PublicAncestor.Question1483;


class TreeAncestor {

    int[][] pa;


    public TreeAncestor(int n, int[] parent) {
        int m=32-Integer.numberOfLeadingZeros(n);
        pa=new int[n][m];
        for(int i=0;i<n;i++){
            pa[i][0]=parent[i];
        }
        //The loop order cannot change
        for(int j=0;j<m-1;j++){
            for (int i=0;i<n;i++){
                int p=pa[i][j];
                if(p<0){
                    pa[i][j+1]=-1;
                }else {
                    pa[i][j+1]=pa[p][j];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int m = 32 - Integer.numberOfLeadingZeros(k); // k 的二进制长度
        for (int i = 0; i < m; i++) {
            if (((k >> i) & 1) > 0) { // k 的二进制从低到高第 i 位是 1
                node = pa[node][i];
                if (node < 0) break;
            }
        }

        return node;
    }

    public static void main(String[] args) {
        TreeAncestor treeAncestor=new TreeAncestor(6,new int[]{-1,2,3,4,5,0});
        System.out.println(treeAncestor.getKthAncestor(1,4));
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */