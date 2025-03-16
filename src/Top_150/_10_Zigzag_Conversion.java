package Top_150;

//Given a string s and a number of rows numRows, write the string in a zigzag pattern and read it row by row.

//🧪 Example:
//Input:
//s = "PAYPALISHIRING", numRows = 3
//P   A   H   N
//A P L S I I G
//Y   I   R
//Output: "PAHNAPLSIIGYIR"

//🧪 Dry Run:
//Input: "PAYPALISHIRING", numRows = 3
//Row 0: P A H N
//Row 1: A P L S I I G
//Row 2: Y I R
//Final Output: "PAHNAPLSIIGYIR"

public class _10_Zigzag_Conversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

        int currRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currRow].append(c);
            if (currRow == 0 || currRow == numRows - 1) goingDown = !goingDown;
            currRow = currRow + (goingDown ? 1 : -1);
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) result.append(row);
        return result.toString();
    }
}
