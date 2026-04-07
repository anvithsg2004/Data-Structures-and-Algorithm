package DSA.Sliding_Window;

public class _7_Number_of_Substrings_Containing_All_Three_Characters {

    public int numberOfSubstrings(String s) {
        int n = s.length();

        int i = 0;
        int j = 0;

        int a = 0;
        int b = 0;
        int c = 0;

        int count = 0;

        while (j < n) {

            char letter = s.charAt(j);
            if (letter == 'a') {
                a++;
            } else if (letter == 'b') {
                b++;
            } else if (letter == 'c') {
                c++;
            }

            while (a >= 1 && b >= 1 && c >= 1) {

                count = count + (n - j);

                char insideLetter = s.charAt(i);
                if (insideLetter == 'a') {
                    a--;
                } else if (insideLetter == 'b') {
                    b--;
                } else if (insideLetter == 'c') {
                    c--;
                }

                i++;

            }

            j++;

        }

        return count;
    }
}
