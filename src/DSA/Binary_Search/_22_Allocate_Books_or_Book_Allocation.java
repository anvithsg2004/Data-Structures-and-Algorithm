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
    //Array = [25, 46, 28, 49, 24]
    //1) 25|46|28|49,24 = 73
    //2) 25|45|28,49|24 = 77
    //3) 25|46,28|49|24 = 74
    //4) 25,46|28|49|24 = 71

    //So take the 4) this is the problem.

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

    public static void main(String[] args) {

    }
}
