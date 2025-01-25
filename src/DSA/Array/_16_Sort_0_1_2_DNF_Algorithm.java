package DSA.Array;

public class _16_Sort_0_1_2_DNF_Algorithm {

    public static void DNF(int[] array) {
        int n = array.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        // 0 (0) low - 1
        // low (1) mid - 1
        //mid (0/1/2) high
        //high + 1 (2) n - 1
        while (mid <= high) {
            //Case - 1 :- Swap
            //Swap Low and Mid
            if (array[mid] == 0) {
                int temp = array[low];
                array[low] = array[mid];
                array[mid] = temp;

                low++;
                mid++;
                //Case - 2 :- Just Increment
            } else if (array[mid] == 1) {
                mid++;
            }
            //Case - 3 :- Swap
            //Swap Mid and High
            else {
                int temp = array[mid];
                array[mid] = array[high];
                array[high] = temp;

                high--;
            }
        }
    }
}
