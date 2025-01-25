package DSA.LeetCode.Strings;

public class Sum_of_Digits_of_String_After_Convert {

    public static int getLucky(String s, int k) {

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a' + 1;
            while (num > 0) {
                sum = sum + (num % 10);
                num = num / 10;
            }
        }

        for (int i = 0; i < k - 1; i++) {
            int temp = 0;
            while (sum > 0) {
                temp = temp + (sum % 10);
                sum = sum / 10;
            }
            sum = temp;
        }

        return sum;
    }

    public static void main(String[] args) {
        String s = "iiii";
        int arr = getLucky(s, 1);
        System.out.println(arr);
    }
}
