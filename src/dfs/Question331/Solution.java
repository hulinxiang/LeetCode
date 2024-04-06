package dfs.Question331;

public class Solution {
    private int length=0;

    public boolean isValidSerialization(String preorder) {
        String[] symbols=preorder.split(",");
        dfs(symbols);
        return length==symbols.length;
    }


    public void dfs(String[] symbols){
        if (length>=symbols.length){
            length++;
            return;
        }
        if(symbols[length].equals("#")){
            length++;
            return;
        }
        length++;
        dfs(symbols);
        dfs(symbols);
    }


}