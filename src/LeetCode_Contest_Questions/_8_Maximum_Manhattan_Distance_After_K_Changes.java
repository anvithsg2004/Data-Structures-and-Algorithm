package LeetCode_Contest_Questions;


//Yet to solve
public class _8_Maximum_Manhattan_Distance_After_K_Changes {

    public int[] findTheNextCoordinates(int[] coordinates, char c) {
        int x = coordinates[0], y = coordinates[1];

        if (c == 'N') {
            y += 1;
        } else if (c == 'S') {
            y -= 1;
        } else if (c == 'W') {
            x -= 1;
        } else if (c == 'E') {
            x += 1;
        }

        return new int[]{x, y}; // Return updated coordinates

    }

    public int maxDistance(String s, int k) {

        int[] previousCoordinates = {0, 0};

        int n = s.length();

        int maxi = 0;

        for (int i = 0; i < n; i++) {
            previousCoordinates = findTheNextCoordinates(previousCoordinates, s.charAt(i));

            maxi = Math.max(maxi, Math.abs(Math.abs(previousCoordinates[0]) + Math.abs(previousCoordinates[1])));

        }

        return maxi;

    }
}
