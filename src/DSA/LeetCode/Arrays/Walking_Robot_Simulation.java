package DSA.LeetCode.Arrays;

import java.util.HashSet;
import java.util.Set;

public class Walking_Robot_Simulation {

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int[][] directions = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        int x = 0;
        int y = 0;
        int distance = 0;
        int maxDistance = 0;

        for (int command : commands) {
            if (command == -1) {
                distance = (distance + 1) % 4;
            } else if (command == -2) {
                distance = (distance + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int newX = x + directions[distance][0];
                    int newY = y + directions[distance][1];
                    if (!obstacleSet.contains(newX + "," + newY)) {
                        x = newX;
                        y = newY;
                        maxDistance = Math.max(maxDistance, (x * x) + (y * y));
                    } else {
                        break;
                    }
                }
            }
        }

        return maxDistance; 
    }

    public static void main(String[] args) {

    }
}
