package DSA.Practice.Binary_Search.Medium;

public class _11_H_Index_II {

    public boolean isPossible(int[] citations, int papers) {

        int n = citations.length;

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (citations[i] >= papers) {

                count++;

            }

        }

        return count >= papers;

    }

    public int hIndex(int[] citations) {

        int n = citations.length;

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
