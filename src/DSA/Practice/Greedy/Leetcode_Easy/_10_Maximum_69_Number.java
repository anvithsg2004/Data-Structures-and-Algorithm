package DSA.Practice.Greedy.Leetcode_Easy;

public class _10_Maximum_69_Number {

    //My Solution
    public int maximum69Number(int num) {

        String strNum = Integer.toString(num);
        int[] digits = new int[strNum.length()];

        for (int i = 0; i < strNum.length(); i++) {
            digits[i] = Character.getNumericValue(strNum.charAt(i));
        }

        for (int i = 0; i < strNum.length(); i++) {
            if (digits[i] == 6) {
                digits[i] = 9;
                break;
            }
        }

        int number = 0;

        // Iterate over the array and construct the number
        for (int digit : digits) {
            number = number * 10 + digit;
        }

        return number;

    }


    //OG Solution
    public int maximum69Number2(int num) {
        String numStr = Integer.toString(num);
        numStr = numStr.replaceFirst("6", "9");
        return Integer.valueOf(numStr);
    }
}
