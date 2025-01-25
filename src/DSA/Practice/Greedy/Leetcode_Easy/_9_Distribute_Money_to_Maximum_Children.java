//package DSA.Practice.Greedy.Leetcode_Easy;
//
//public class _9_Distribute_Money_to_Maximum_Children {
//    public int distMoney(int money, int children) {
//
//        if (money < children) {
//            return -1;
//        }
//
//        int noOfChildrenGet8 = money / children;
//
//        if (noOfChildrenGet8 == 0) {
//            return 0;
//        }
//
//        int multiply = children * 8;
//
//        if (multiply == money) {
//            return children;
//        }
//
//        int moneyMul = children * 8;
//        int moneyDiv = money / 8;
//        int moneyRem = money % 8;
//
//        int[] result = new int[children];
//
//        for (int i = 0; i < moneyDiv; i++) {
//            result[i] = 8;
//        }
//
//        int zeroCount = 0;
//
//        for (int i = 0; i < children; i++) {
//            if (result[i] == 0) {
//                zeroCount++;
//            }
//        }
//
//        if (zeroCount == 0 && moneyRem != 4) {
//            result[children - 1] = result[children - 1] + moneyRem;
//        }
//
//        if (zeroCount == 0 && moneyRem == 4) {
//            result[children - 1] = result[children - 1] + moneyRem;
//        }
//
//        if (zeroCount != 0 && moneyRem == 4) {
//
//        }
//
//    }
//}
