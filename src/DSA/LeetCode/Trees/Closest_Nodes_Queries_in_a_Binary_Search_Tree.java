package DSA.LeetCode.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Closest_Nodes_Queries_in_a_Binary_Search_Tree {

    public void inorder(TreeNode root, List<Integer> sortedList) {
        if (root == null) {
            return;
        }

        inorder(root.left, sortedList);
        sortedList.add(root.val);
        inorder(root.right, sortedList);
    }

    public int binarySearch(List<Integer> list, int query) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) == query) {
                return mid;
            } else if (list.get(mid) > query) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> sortedList = new ArrayList<>();
        inorder(root, sortedList);

        int n = sortedList.size();
        List<List<Integer>> result = new ArrayList<>();

        for (int query : queries) {
            int insertIndex = binarySearch(sortedList, query);

            int min = -1;
            int max = -1;

            if (insertIndex < n && sortedList.get(insertIndex) == query) {
                min = query;
                max = query;
            }
            else {
                if (insertIndex - 1 >= 0) {
                    min = sortedList.get(insertIndex-1);
                }

                if (insertIndex < n) {
                    max = sortedList.get(insertIndex);
                }
            }
            result.add(Arrays.asList(min, max));
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
