package DSA.Strings;

public class _4_String_Rotated_by2_Places {

    public boolean isRotated(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false; // If the lengths don't match, it can't be a rotation
        }

        // Check for clockwise rotation and anticlockwise rotation
        return clock(str1, str2) || antiClock(str1, str2);
    }

    // Check if str2 is a clockwise rotation of str1 by 2 places
    public boolean clock(String str1, String str2) {
        String rotatedClock = str1.substring(str1.length() - 2) + str1.substring(0, str1.length() - 2);
        return rotatedClock.equals(str2);
    }

    // Check if str2 is an anticlockwise rotation of str1 by 2 places
    public boolean antiClock(String str1, String str2) {
        String rotatedAntiClock = str1.substring(2) + str1.substring(0, 2);
        return rotatedAntiClock.equals(str2);
    }

    public static void main(String[] args) {

    }
}
