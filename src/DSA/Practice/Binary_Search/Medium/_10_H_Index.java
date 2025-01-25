package DSA.Practice.Binary_Search.Medium;

import java.util.Arrays;

public class _10_H_Index {

    //Input: citations = [3, 0, 6, 1, 5], n = 5
    //H-Index can be up to 5:
    //Check h = 5: Are there at least 5 papers with 5 or more citations? No.
    //Check h = 4: Are there at least 4 papers with 4 or more citations? No.
    //Check h = 3: Are there at least 3 papers with 3 or more citations? Yes.

    public boolean isPossible(int[] citations, int papers) {

        int count = 0;

        int n = citations.length;

        for (int i = 0; i < n; i++) {

            if (citations[i] >= papers) {
                count++;
            }

        }

        return count >= papers;

    }

    public int hIndex(int[] citations) {

        int n = citations.length;

        Arrays.sort(citations);

        int low = 0;
        int high = n;

        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(citations, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return ans;

    }

    public static void main(String[] args) {

    }
}
