package DSA.Practice.BackTracking;

import java.util.*;

public class _1_Binary_Watch {

    public List<String> readBinaryWatch(int turnedOn) {

        if (turnedOn == 0) {
            return List.of("0:00");
        }

        List<String> result = new ArrayList<>();

        int[] hours = {1, 2, 4, 8};
        int[] minutes = {1, 2, 4, 8, 16, 32};

        ArrayList<Integer> validHours = new ArrayList<>();
        ArrayList<Integer> validMinutes = new ArrayList<>();

        for (int i = 0; i <= Math.min(turnedOn, 4); i++) {

            validHours.clear();
            addHours(hours, 0, i, 0, validHours);

            validMinutes.clear();
            addMinutes(minutes, 0, turnedOn - i, 0, validMinutes);

            // Combine hours and minutes to form valid times
            for (int hour : validHours) {
                for (int minute : validMinutes) {
                    result.add(hour + ":" + String.format("%02d", minute));
                }
            }

        }

        return result;

    }

    public void addHours(int[] hours, int index, int turnedOn, int sum, ArrayList<Integer> answer) {
        if (turnedOn == 0) {
            if (sum < 12) {
                answer.add(sum);
                return;
            }
        }

        if (index == hours.length) {
            return;
        }

        //Pick
        addHours(hours, index + 1, turnedOn - 1, sum + hours[index], answer);

        //Do not pick
        addHours(hours, index + 1, turnedOn, sum, answer);

    }

    public void addMinutes(int[] minutes, int index, int turnedOn, int sum, ArrayList<Integer> answer) {

        if (turnedOn == 0) {
            if (sum < 60) {
                answer.add(sum);
                return;
            }
        }

        if (index == minutes.length) {
            return;
        }

        //Pick
        addMinutes(minutes, index + 1, turnedOn - 1, sum + minutes[index], answer);

        //Not Pick
        addMinutes(minutes, index + 1, turnedOn, sum, answer);

    }
}
