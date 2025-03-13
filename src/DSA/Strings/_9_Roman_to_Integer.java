package DSA.Strings;

public class _9_Roman_to_Integer {

    public int num(char c) {  // Method to map Roman characters to their integer values
        if (c == 'I') {
            return 1;
        } else if (c == 'V') {
            return 5;
        } else if (c == 'X') {
            return 10;
        } else if (c == 'L') {
            return 50;
        } else if (c == 'C') {
            return 100;
        } else if (c == 'D') {
            return 500;
        }
        return 1000;  // Default case for 'M'
    }

    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }

        int index = 0;  // Start index
        int sum = 0;    // Store the final integer value

        // Traverse till the second last character
        while (index <= s.length() - 2) {
            if (num(s.charAt(index)) < num(s.charAt(index + 1))) {
                // If current numeral is smaller than next, subtract it
                sum = sum - num(s.charAt(index));
            } else {
                // Otherwise, add it to sum
                sum = sum + num(s.charAt(index));
            }
            index++; // Move to next character
        }

        // Add the last numeral (always added)
        sum = sum + num(s.charAt(index));

        return sum;
    }

    /*
    Dry Run Example: "MCMXCIV" (1994)

    Step-wise sum calculation:
    M(1000)  -> 1000 (M > C, add)
    C(100)   -> 900  (C < M, subtract)
    M(1000)  -> 1900 (M > X, add)
    X(10)    -> 1890 (X < C, subtract)
    C(100)   -> 1990 (C > I, add)
    I(1)     -> 1989 (I < V, subtract)
    V(5)     -> 1994 (V is last, add)

    Final Output: 1994 ✅
    */
}
