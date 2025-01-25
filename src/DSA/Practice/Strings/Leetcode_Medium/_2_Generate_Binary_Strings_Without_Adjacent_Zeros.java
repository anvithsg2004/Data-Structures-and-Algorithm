package DSA.Practice.Strings.Leetcode_Medium;

import java.util.ArrayList;
import java.util.List;

public class _2_Generate_Binary_Strings_Without_Adjacent_Zeros {

    public List<String> validStrings(int n) {

        List<String> result = new ArrayList<>();

        if (n == 1) {
            result.add("0");
            result.add("1");
            return result;
        }

        // We need to generate binary numbers from 0 to (2^n - 1)
        int total = (int) Math.pow(2, n);

        for (int i = 0; i < total; i++) {

            // Convert i to a binary string, and pad with leading zeros
            String middle = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');

            boolean isValid = true;

            for (int j = 1; j < middle.length(); j++) {

                char last = middle.charAt(j - 1);
                char now = middle.charAt(j);

                // If two adjacent '0's are found, the string is invalid
                if (last == '0' && now == '0') {
                    isValid = false;
                    break;
                }

            }

            if (isValid) {
                result.add(middle);
            }

        }

        return result;

    }

    public static void main(String[] args) {

    }
}
