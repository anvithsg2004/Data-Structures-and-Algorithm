//package DSA.Practice.Greedy.Leetcode_Easy;
//
//import java.util.Arrays;
//
//public class _16_Minimum_Cost_to_Move_Chips_to_The_Same_Position {
//    public static void minCostToMoveChips(int[] position) {
//
//        int maxi = Integer.MIN_VALUE;
//
//        for (int i = 0; i < position.length; i++) {
//            maxi = Math.max(position[i], maxi);
//        }
//
//        System.out.println(maxi);
//
//        int[] chips = new int[maxi];
//
//        for (int i = 0; i < position.length; i++) {
//            int value = position[i];
//            chips[value - 1] = chips[value - 1] + 1;
//        }
//
//        System.out.println(Arrays.toString(chips));
//
//        int maxiIndex = Integer.MIN_VALUE;
//
//        for (int i = 0; i < chips.length; i++) {
//            if (chips[i] == maxi) {
//                maxiIndex = i;
//                break;
//            }
//        }
//
//        System.out.println(maxiIndex);
//
//
//    }
//
//    public static void main(String[] args) {
//        int[] position = {2, 2, 2, 3, 3};
//        minCostToMoveChips(position);
//    }
//}
