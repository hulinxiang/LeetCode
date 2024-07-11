package Question2732;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * 把每一行弄成一个二进制数，然后存入一个HashMap中，Key为二进制数，value为行号
     *
     * @param grid
     * @return
     */
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        Map<Integer, Integer> maskToIdx = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            int mask = 0;
            for (int j = 0; j < grid[i].length; j++) {
                mask |= grid[i][j] << j;
            }
            if (mask==0){
                return List.of(i);
            }
            maskToIdx.put(mask,i);
        }
        for (Map.Entry<Integer, Integer> e1 : maskToIdx.entrySet()) {
            for (Map.Entry<Integer, Integer> e2 : maskToIdx.entrySet()) {
                if ((e1.getKey() & e2.getKey()) == 0) {
                    int i = e1.getValue();
                    int j = e2.getValue();
                    return i < j ? List.of(i, j) : List.of(j, i);
                }
            }
        }
        return List.of();
    }


}
