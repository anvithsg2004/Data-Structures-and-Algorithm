package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _15_Path_In_Zigzag_Labelled_Binary_Tree {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        list.add(label);
        while (label != 1) {
            // root is zero level
            int height = (int) (Math.log(label) / Math.log(2));
            label = (int) Math.pow(2, height - 1) * (3) - (label / 2) - 1;
            list.add(label);
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {

    }
}
