package DSA.Binary_Search;

//Floor :- Largest Number in an Array <= X
//Ceil :- Smallest Number in Array >= X

class Solution {
    public static int ceil(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = arr[mid];
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static int floor(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] <= x) {
                ans = arr[mid];
                //look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return ans;
    }

    public static int[] _5_Floor_Ceil(int[] a, int n, int x) {
        // Write your code here.
        int d = floor(a, n, x);
        int e = ceil(a, n, x);

        return new int[]{d, e};
    }

}
