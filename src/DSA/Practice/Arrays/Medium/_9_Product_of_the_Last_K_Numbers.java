package DSA.Practice.Arrays.Medium;

import java.util.ArrayList;

public class _9_Product_of_the_Last_K_Numbers {

    ArrayList<Integer> arrayList;

    ArrayList<Integer> prefix;

    ArrayList<Integer> suffix;

    public _9_Product_of_the_Last_K_Numbers() {
        arrayList = new ArrayList<>();
    }

    public void add(int num) {
        arrayList.add(num);
    }

    public int getProduct(int k) {
        int product = 1;
        int n = arrayList.size();

        int diff = n - k + 1;

        for (int i = n - 1; i >= diff; i--) {
            product = product * arrayList.get(i);
        }

        return product;
    }
}
