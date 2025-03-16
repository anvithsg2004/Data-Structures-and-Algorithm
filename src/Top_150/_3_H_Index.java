package Top_150;

//Input: [3,0,6,1,5] → Sorted: [0,1,3,5,6]
//Check:
//
//0 >= 5? No
//1 >= 4? No
//3 >= 3? Yes → H-index = 3

//Given an array citations[] where citations[i] = number of citations for paper i, return the H-index of the researcher.
//H-index definition: Maximum h such that the researcher has at least h papers with ≥ h citations each.

import java.util.Arrays;

public class _3_H_Index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}
