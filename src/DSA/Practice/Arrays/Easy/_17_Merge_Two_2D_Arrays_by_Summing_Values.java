package DSA.Practice.Arrays.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _17_Merge_Two_2D_Arrays_by_Summing_Values {

    //OG Solution
    public int[][] mergeArrays2(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length, n2 = nums2.length, i = 0, j = 0;
        ArrayList<int[]> ans = new ArrayList();
        while (i < n1 && j < n2) {
            if (nums1[i][0] == nums2[j][0]) {
                ans.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                ans.add(nums1[i]);
                i++;
            } else {
                ans.add(nums2[j]);
                j++;
            }
        }
        while (i < n1) {
            ans.add(nums1[i++]);
        }
        while (j < n2) {
            ans.add(nums2[j++]);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    //Brute Force Solution
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int n = nums1.length;
        int m = nums2.length;

        for (int i = 0; i < n; i++) {
            hashMap.put(nums1[i][0], nums1[i][1]);
        }

        for (int i = 0; i < m; i++) {
            if (hashMap.containsKey(nums2[i][0])) {
                hashMap.put(nums2[i][0], hashMap.get(nums2[i][0]) + nums2[i][1]);
            } else {
                hashMap.put(nums2[i][0], nums2[i][1]);
            }
        }

        System.out.println(hashMap);

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(hashMap);

        int resulSize = hashMap.size();

        int[][] result = new int[resulSize][2];

        int index = 0; // Row index for result matrix

        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            result[index][0] = entry.getKey();   // Store key in column 0
            result[index][1] = entry.getValue(); // Store value in column 1
            index++; // Move to next row
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
        mergeArrays(nums1, nums2);
    }
}
