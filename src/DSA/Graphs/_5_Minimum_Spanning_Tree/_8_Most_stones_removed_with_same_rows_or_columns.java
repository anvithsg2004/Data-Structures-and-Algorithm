package DSA.Graphs._5_Minimum_Spanning_Tree;

//Answer = No fo Stones - No of Components

//Rows are treated as Nodes in DS
//Col are treated as nodes on DS

//Like We have matrix 5 * 4;
//So now Rows are [0, 1, 2, 3, 4],
//Now the col is [5, 6, 7, 8]

import java.util.HashMap;
import java.util.Map;

public class _8_Most_stones_removed_with_same_rows_or_columns {
    public int maxRemove(int[][] stones, int n) {
        //n = No of stones in the matrix
        //This is to find till where the matrix is going.
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][0]);
        }

        _4_Union_by_Rank ds = new _4_Union_by_Rank(maxRow + maxCol + 1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1];
            ds.unionByRank(nodeRow, nodeCol);
            hashMap.put(nodeRow, 1);
            hashMap.put(nodeCol, 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> it : hashMap.entrySet()) {
            if (ds.findPar(it.getKey()) == it.getKey()) {
                count++;
            }
        }

        return n - count;
    }
}
