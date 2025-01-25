package DSA.LeetCode.Dynamic_Programming;

public class Filling_Bookcase_Shelves {

    int totalBooks;
    int shelfWidth;

    public int findMinHeight(int bookIndex, int[][] books, int curShelfWidth, int curShelfHeight) {
        // If we are at the last book
        if (bookIndex == totalBooks) {
            return curShelfHeight;
        }

        int bookWidth = books[bookIndex][0];
        int bookHeight = books[bookIndex][1];

        // Option 1: Place the current book on the same shelf
        int sameShelfHeight = Integer.MAX_VALUE;
        if (bookWidth <= curShelfWidth) {
            sameShelfHeight = findMinHeight(bookIndex + 1, books, curShelfWidth - bookWidth, Math.max(curShelfHeight, bookHeight));
        }

        // Option 2: Place the current book on a new shelf
        int newShelfHeight = curShelfHeight + findMinHeight(bookIndex + 1, books, shelfWidth - bookWidth, bookHeight);

        return Math.min(sameShelfHeight, newShelfHeight);
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.totalBooks = books.length;
        this.shelfWidth = shelfWidth;
        return findMinHeight(0, books, shelfWidth, 0);
    }

    public int minHeightShelves_2(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];

        // Initialize dp array with a large value
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0; // Base case: no books, no height

        for (int i = 1; i <= n; i++) {
            int width = 0;
            int height = 0;

            // Try to place books i, i-1, ..., 1 on the same shelf
            for (int j = i; j > 0; j--) {
                width += books[j - 1][0];
                if (width > shelfWidth) {
                    break;
                }
                height = Math.max(height, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

    }
}
