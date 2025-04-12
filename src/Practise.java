public class Practise {
    public static String removeOccurrences(String s, String part) {

        boolean didChanged = false;

        StringBuilder result = new StringBuilder(s);

        while (!didChanged) {

            int indexOfThePart = result.indexOf(part);

            if (indexOfThePart != -1) {
                result.delete(indexOfThePart, indexOfThePart + part.length());
            } else {
                didChanged = true;
            }

        }

        return result.toString();

    }

    public static void main(String[] args) {
        String s = "axxxxyyyyb";
        String part = "xy";

        System.out.println(removeOccurrences(s, part));
    }
}
