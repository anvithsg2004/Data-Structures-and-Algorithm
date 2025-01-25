package DSA.Practice.Arrays.Easy;

import java.math.BigInteger;
import java.util.HashMap;

public class _9_X_of_a_Kind_in_a_Deck_of_Cards {

    public boolean hasGroupsSizeX(int[] deck) {

        int n = deck.length;

        if (n == 1) {
            return false;
        }

        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < n; i++) {

            frequency.put(deck[i], frequency.getOrDefault(deck[i], 0) + 1);

        }

        // Step 3: Find the GCD of all the card frequencies
        int gcd = 0;
        for (int count : frequency.values()) {
            gcd = gcd == 0 ? count : BigInteger.valueOf(gcd).gcd(BigInteger.valueOf(count)).intValue();
        }

        // Step 4: Check if the GCD is greater than 1
        return gcd > 1;

    }

    public static void main(String[] args) {

    }
}
