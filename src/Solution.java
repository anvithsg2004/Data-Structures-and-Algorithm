class Solution {
    public String largestOddNumber(String num) {

        int n = num.length();

        int oddIndex = 0;

        for (int i = n - 1; i >= 0; i--) {

            char ch = num.charAt(i);
            int number = ch - '0';

            if (number % 2 != 0) {
                oddIndex = i;
                break;
            }

        }

        return num.substring(0, oddIndex);

    }
}
