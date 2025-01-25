package DSA.Practice.Strings.Leetcode_Easy;

import java.util.Objects;

public class _2_Final_Value_of_Variable_After_Performing_Operations {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;

        for (int i = 0; i < operations.length; i++) {
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
