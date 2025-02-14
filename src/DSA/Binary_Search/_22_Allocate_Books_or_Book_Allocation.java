package DSA.Binary_Search;

import java.util.ArrayList;
import java.util.Collections;

public class _22_Allocate_Books_or_Book_Allocation {

    //Problem Statement :-
    //1) Each student gets at least one book.
    //2) Each book should be allocated to only one student.
    //3) Book allocation should be in a contiguous manner.

    //Main Part :- The maximum number of pages assigned to a student is minimum.

    //Examples :-
    //Input: arr[] = [12, 34, 67, 90], k = 2
    //Output: 113
    //Explanation: Books can be distributed in following ways:
    //[12] and [34, 67, 90] – The maximum pages assigned to a student is  34 + 67 + 90 = 191.
    //[12, 34] and [67, 90] – The maximum pages assigned to a student is 67 + 90 = 157.
    //[12, 34, 67] and [90] – The maximum pages assigned to a student is 12 + 34 + 67 = 113.
    //The third combination has the minimum pages assigned to a student which is 113.

    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size(); // size of array
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                // add pages to current student
                pagesStudent += arr.get(i);
            } else {
                // add pages to next student
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // book allocation impossible
        if (m > n)
            return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
