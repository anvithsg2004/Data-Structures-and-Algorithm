package DSA.Practice.Binary_Search.Easy;

public class _10_Arranging_Coins {

    public int arrangeCoins(int n) {

        int i = 0; // Initialize the row counter
        while (n > 0 && n > i) { // Continue until there aren't enough coins to form the next row
            i++; // Increment the row number
            n = n - i; // Subtract the current row number of coins from n
        }
        return i; // Return the number of complete rows

    }

    public static void main(String[] args) {

    }
}
