package DSA.Practice.Binary_Search.Easy;

import java.util.HashSet;

public class _13_Minimum_Common_Value {

    public static int getCommon(int[] nums1, int[] nums2) {

        int i = 0;
        int j = 0;

        int n1 = nums1.length;
        int n2 = nums2.length;

        while (n1 > i && n2 > j) {

            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }

        }

        return -1;

    }

    public int getCommon1(int[] nums1, int[] nums2) {

        HashSet<Integer> ans = new HashSet<>();

        for (int i = 0; i < nums2.length; i++) {

            ans.add(nums2[i]);

        }

        for (int i = 0; i < nums1.length; i++) {

            if (ans.contains(nums1[i])) {

                return nums1[i];

            }

        }

        return -1;

    }


    public int getCommon2(int[] nums1, int[] nums2) {

        for (int i = 0; i < nums1.length; i++) {

            int low = 0;

            int high = nums2.length - 1;

            while (low <= high) {

                int mid = (low + high) / 2;

                if (nums1[i] == nums2[mid]) {

                    return nums1[i];

                } else if (nums1[i] < nums2[mid]) {

                    high = mid - 1;

                } else if (nums1[i] > nums2[mid]) {

                    low = mid + 1;

                }

            }

        }

        return -1;

    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {2, 3, 4, 5, 6};
        System.out.println(getCommon(nums1, nums2));

    }
}
