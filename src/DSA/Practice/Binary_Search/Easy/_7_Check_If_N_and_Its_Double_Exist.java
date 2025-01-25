package DSA.Practice.Binary_Search.Easy;

import java.util.Arrays;

public class _7_Check_If_N_and_Its_Double_Exist {

    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            int k = arr.length - 1;

            while (j <= k) {
                int mid = j + (k - j) / 2;
                if (arr[i] * 2 == arr[mid] && i != mid) {
                    return true;
                } else if (arr[i] * 2 > arr[mid]) {
                    j = mid + 1;
                } else {
                    k = mid - 1;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {

    }
}
