package DSA.Practice.Strings.Leetcode_Medium;

public class _6_Execution_of_All_Suffix_Instructions_Staying_in_a_Grid {

    public int[] executeInstructions(int n, int[] startPos, String s) {

        int[] result = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {

            int row = startPos[0];

            int col = startPos[1];

            int count = 0;

            for (int j = i; j < s.length(); j++) {

                char instruction = s.charAt(j);

                if (instruction == 'L') {
                    col--;  // Move left
                } else if (instruction == 'R') {
                    col++;  // Move right
                } else if (instruction == 'U') {
                    row--;  // Move up
                } else if (instruction == 'D') {
                    row++;  // Move down
                }


                if (row >= 0 && row < n && col >= 0 && col < n) {
                    count++;  // Increment count of valid instructions executed
                } else {
                    break;  // Stop if the move goes out of bounds
                }

            }

            result[i] = count;

        }

        return result;

    }

    public static void main(String[] args) {

    }
}
