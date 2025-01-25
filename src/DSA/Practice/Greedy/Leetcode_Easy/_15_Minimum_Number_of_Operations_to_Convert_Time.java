package DSA.Practice.Greedy.Leetcode_Easy;

public class _15_Minimum_Number_of_Operations_to_Convert_Time {
    public static int convertTime(String current, String correct) {
        int currentMinutesLength = current.length();
        int correctMinutesLength = correct.length();

        int currentHour = Integer.parseInt(String.valueOf(current.substring(0, 2)));
        int currentMinutes = Integer.parseInt(String.valueOf(current.substring(3, 5)));
        int currentHourInMinutes = currentHour * 60;

        int correctHour = Integer.parseInt(String.valueOf(correct.substring(0, 2)));
        int correctMinutes = Integer.parseInt(String.valueOf(correct.substring(3, 5)));
        int correctHourInMinutes = correctHour * 60;

        int currentTotal = currentHourInMinutes + currentMinutes;
        int correctTotal = correctHourInMinutes + correctMinutes;

        System.out.println(currentTotal + "  " + correctTotal);

        int remainingTimeInMinutes = correctTotal - currentTotal;

        int hoursToShift = remainingTimeInMinutes / 60;

        int minutesToShift = remainingTimeInMinutes % 60;

        int[] minutes = {1, 5, 15, 60};

        int left = minutes.length - 1;

        int count = 0;

        while (minutesToShift > 0 && left >= 0) {
            if (minutesToShift >= minutes[left]) {
                count += minutesToShift / minutes[left]; // How many times this operation fits
                minutesToShift %= minutes[left];        // Remaining time after applying this operation
            } else {
                left--; // Move to the next smaller operation
            }
        }

        return hoursToShift + count;
    }

    public static void main(String[] args) {
        String current = "02:30";
        String correct = "04:35";
        System.out.println(convertTime(current, correct));
    }
}
