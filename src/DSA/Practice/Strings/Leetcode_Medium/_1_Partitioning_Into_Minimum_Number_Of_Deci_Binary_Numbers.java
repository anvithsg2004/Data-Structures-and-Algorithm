package DSA.Practice.Strings.Leetcode_Medium;

public class _1_Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers {

    //Return the maximum digit in the string.

    public int minPartitions(String n) {
        int max = 0;

        // Loop through each character in the string
        for (int i = 0; i < n.length(); i++) {
            // Convert the current character to its integer value
            int digit = n.charAt(i) - '0';

            // Update max if the current digit is larger
            if (digit > max) {
                max = digit;
            }

            // If max is 9, we can stop early as 9 is the largest possible digit
            if (max == 9) {
                break;
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
