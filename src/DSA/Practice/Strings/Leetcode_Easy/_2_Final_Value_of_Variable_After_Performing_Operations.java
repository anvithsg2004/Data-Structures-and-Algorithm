package DSA.Practice.Strings.Leetcode_Easy;

import java.util.Objects;

//This function calculates the final value of a variable x, which is initially 0, after applying a series of operations on it.
//The operations can be:
//"++X" → Pre-increment (++x)
//"--X" → Pre-decrement (--x)
//"X++" → Post-increment (x++)
//"X--" → Post-decrement (x--)

public class _2_Final_Value_of_Variable_After_Performing_Operations {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;

        for (int i = 0; i < operations.length; i++) {

            //Objects.equals(a, b) is a null-safe way to compare two objects.
            //It prevents NullPointerException if operations[i] is null.

            if (Objects.equals(operations[i], "++X")) {
                ++x;
            } else if (Objects.equals(operations[i], "--X")) {
                --x;
            } else if (Objects.equals(operations[i], "X++")) {
                x++;
            } else if (Objects.equals(operations[i], "X--")) {
                x--;
            }
        }

        return x;
    }

    public static void main(String[] args) {

    }
}
