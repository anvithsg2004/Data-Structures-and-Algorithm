package DSA.Subarrays._2_Sliding_Window;

public class _4_Maximum_Number_of_Vowels_in_a_Substring_of_Size_K {

    public static int maxVowels(String s, int k) {

        int n = s.length();

        int maxVowel = 0;

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (isVowel(s.charAt(i))) {
                count++;
            }

            if (i >= k && isVowel(s.charAt(i - k))) {
                count--;
            }

            maxVowel = Math.max(maxVowel, count);

        }

        return maxVowel;

    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
