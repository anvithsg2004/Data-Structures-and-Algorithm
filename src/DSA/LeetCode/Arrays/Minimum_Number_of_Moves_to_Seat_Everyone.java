package DSA.LeetCode.Arrays;

import java.util.PriorityQueue;

//Optimal Solution
//class Solution {
//    public int minMovesToSeat(int[] seats, int[] students) {
//        Arrays.sort(seats);
//        Arrays.sort(students);
//        int val=0;
//        for(int i=0;i<seats.length;i++){
//
//            val += Math.abs(seats[i]-students[i]);
//        }
//        return val;
//    }
//}

public class Minimum_Number_of_Moves_to_Seat_Everyone {

    public int mini(int[] seats, int[] students) {
        int ans = 0;

        PriorityQueue<Integer> seat = new PriorityQueue<>();
        PriorityQueue<Integer> student = new PriorityQueue<>();

        for (int i = 0; i < seats.length; i++) {
            seat.add(seats[i]);
            student.add(students[i]);
        }

        while (!seat.isEmpty()) {
            int a = seat.poll();
            int b = student.poll();

            ans = ans + Math.abs(a - b);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
