package DSA.Hashing;

import java.util.Scanner;
import java.util.Arrays;

public class _1_Frequency_Number {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Lenght of Array : " );
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter for " + arr[i] + " : ");
            arr[i] = in.nextInt();
        }
        System.out.println("The values in the Array : ");
        System.out.println(Arrays.toString(arr));


        //Precompute
        int[] hash = new int[13];
        for (int i = 0; i < n; i++) {
            hash[arr[i]] = hash[arr[i]] + 1;
        }



        int q = in.nextInt();
        while (q > 0) {
            int number = in.nextInt();
            //Fetch
            System.out.println(hash[number]);
            q--;
        }
    }
}
