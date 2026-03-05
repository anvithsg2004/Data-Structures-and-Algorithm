package DSA;

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNext()) {
            int t = sc.nextInt();

            while (t-- > 0) {

                int hoursBefore = sc.nextInt();

                if (10 - hoursBefore >= 3) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }

            }

        }

    }
}
