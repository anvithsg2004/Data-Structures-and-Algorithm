package DSA.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _31_Merge_Overlapping_Intervals {

    //Optimal Code
    public List<List<Integer>> merge2(int[][] intervals) {

        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            //If the List is empty
            //OR
            //the current interval array index is greater than the previous then make a new List and add to it.
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(1)) {

                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));

            } else {

                //Update with interval last number or the List last Number
                //Example :- (2, 6) == List and (3, 8) == New Interval
                //Result :- (2, 8).
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), intervals[i][1]));

            }

        }

        return ans;

    }


    //Brute Force Code
    public List<List<Integer>> merge(int[][] intervals) {

        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            //Skip all the merged intervals:
            //If the ans last end is greater than do not do anything.
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            //check the rest of the intervals:
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));

        }

        return ans;

    }

    public static void main(String[] args) {

    }
}
