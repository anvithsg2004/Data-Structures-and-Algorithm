package DSA.Hashing;

import java.util.Scanner;
import java.util.Arrays;

public class _2_Character_Frequency {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println("The String is : " + s);

        //Precompute
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        int q = in.nextInt();
        while (q > 0) {
            String c = in.nextLine();

            //Fetch
//            int index = c - 'a';
            System.out.println();
            q--;
        }
    }
}
