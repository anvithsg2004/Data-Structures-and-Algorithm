package DSA.Array;

import java.util.*;

public class _29_3_Sum {

    //Optimal Solution
    public List<List<Integer>> threeSum3(int[] arr) {

        int n = arr.length;

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {

            //Removing Duplicates.
            if (i != 0 && arr[i] == arr[i - 1]) continue;

            //Moving 2 Pointers.
            int j = i + 1;
            int k = n - 1;

            while (j < k) {

                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {

                    j++;

                } else if (sum > 0) {

                    k--;

                } else {

                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;

                    //skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }

                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }

                }

            }

        }

        return ans;

    }

    //Better Approach
    public List<List<Integer>> threeSum2(int[] arr) {

        int n = arr.length;

        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                //Calculate the 3rd element:
                int third = -(arr[i] + arr[j]);

                //Find the element in the set:
                //If the set has any element, then there is an element in the set.
                if (hashset.contains(third)) {
                    //Take that and put it in the List and sort it.
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                hashset.add(arr[j]);
            }
        }

        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;

    }


    //Brute Force Order
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;

        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        //To sort in the Natural Ascending Order.
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }

        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;

    }

    public static void main(String[] args) {

    }
}
