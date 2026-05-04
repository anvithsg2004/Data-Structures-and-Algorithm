package neetcode150._2_Two_Pointers;

public class _1_Valid_Palindrome {
    public static boolean isPalindrome(String s) {

        int n = s.length();

        StringBuilder updatedS = new StringBuilder();

        for (int i = 0; i < n; i++) {

            char currentChar = s.charAt(i);

            if (isAlpha(currentChar)) {
                if (currentChar >= 'A' && currentChar <= 'Z') {
                    char updatedChar = (char) (currentChar + 32);
                    updatedS.append(updatedChar);
                } else {
                    updatedS.append(currentChar);
                }
            }

        }

        System.out.println(updatedS.toString());

        if (updatedS.length() == 1) {
            return false;
        }

        int left = 0;
        int right = updatedS.length() - 1;

        while (left <= right) {

            char leftChar = updatedS.charAt(left);
            char rightChar = updatedS.charAt(right);

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;

        }

        return true;

    }

    public static boolean isAlpha(char currentChar) {

        return (currentChar >= 'a' && currentChar <= 'z') || (currentChar >= 'A' && currentChar <= 'Z') || (currentChar - '0' >= 0 && currentChar - '0' <= 9);

    }
}
