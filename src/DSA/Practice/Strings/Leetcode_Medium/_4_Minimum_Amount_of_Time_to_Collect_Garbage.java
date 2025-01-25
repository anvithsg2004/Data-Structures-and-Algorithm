package DSA.Practice.Strings.Leetcode_Medium;

public class _4_Minimum_Amount_of_Time_to_Collect_Garbage {

    public int garbageCollection(String[] garbage, int[] travel) {

        int[] totalTimeForGarbage = new int[3];
        int[] lastVisitedHouse = new int[3];
        String[] garbageType = {"M", "G", "P"};

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < garbage.length; j++) {

                if (garbage[j].contains(garbageType[i])) {

                    for (int k = 0; k < garbage[j].length(); k++) {

                        if (garbage[j].charAt(k) == garbageType[i].charAt(0)) {

                            totalTimeForGarbage[i]++;

                        }

                    }

                    lastVisitedHouse[i] = j;

                }

            }

        }

        int totalTravelTime = 0;

        for (int i = 1; i < garbage.length; i++) {

            for (int j = 0; j < 3; j++) {

                if (i <= lastVisitedHouse[j]) {

                    totalTravelTime = totalTravelTime + travel[i - 1];

                }

            }

        }

        return totalTimeForGarbage[0] + totalTimeForGarbage[1] + totalTimeForGarbage[2] + totalTravelTime;

    }

    public static void main(String[] args) {

    }
}
