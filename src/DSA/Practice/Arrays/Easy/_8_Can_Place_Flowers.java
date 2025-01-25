package DSA.Practice.Arrays.Easy;

public class _8_Can_Place_Flowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int size = flowerbed.length;

        boolean[] planted = new boolean[size];

        for (int i = 0; i < size; i++) {


            if (flowerbed[i] == 1) {

                planted[i] = true;

            }

        }

        int count = 0;

        for (int i = 1; i < size - 1; i++) {

            if (planted[i - 1] == false && planted[i + 1] == false && planted[i] == false) {

                planted[i] = true;

                count++;

            }

        }

        int differ = Math.abs(count - n);

        if (differ == 0) {
            return true;
        }


        return false;

    }
    //Your revised code still needs a few modifications to work as intended.
    // Currently, it only checks from the second to the second-to-last elements (i = 1 to size - 2),
    // which skips the first and last elements.


    //ChatGPT Code
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {

        int size = flowerbed.length;

        boolean[] planted = new boolean[size];

        for (int i = 0; i < size; i++) {


            if (flowerbed[i] == 1) {

                planted[i] = true;

            }

        }

        int count = 0;

        // Traverse the flowerbed to place new flowers where possible
        for (int i = 0; i < size; i++) {
            if (planted[i] == false &&
                    (i == 0 || planted[i - 1] == false) &&
                    (i == size - 1 || planted[i + 1] == false)) {

                // Mark this spot as planted
                planted[i] = true;
                count++;

                // Skip the next index to avoid adjacent planting
                i++;
            }

            // Early exit if enough flowers have been placed
            if (count >= n) {
                return true;
            }
        }

        // Check if the number of flowers placed is enough
        return count >= n;

    }

    public static void main(String[] args) {

    }
}
