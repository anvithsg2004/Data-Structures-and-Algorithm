package DSA.Stack_and_Queue;

public class _16_The_Celebrity_Problem {

    public int celebrityProblem2(int[][] matrix) {

        int n = matrix.length;

        int top = 0;
        int down = n - 1;

        while (top < down) {

            if (matrix[top][down] == 1) {
                top = top + 1;
            } else if (matrix[down][top] == 1) {
                down = down - 1;
            } else {
                top = top + 1;
                down = down - 1;
            }

        }

        if (top > down) {
            return -1;
        }

        // top is now the potential celebrity
        int candidate = top;

        // Validation phase to confirm the candidate
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue; // Skip self-check

            // If a candidate knows someone, or someone doesn't know candidate
            if (matrix[candidate][i] == 1 || matrix[i][candidate] == 0) {
                return -1; // Candidate is not a celebrity
            }
        }

        return candidate; // Candidate is the celebrity

    }

    public int celebrityProblem(int[][] matrix) {

        int n = matrix.length;

        int[] knowMe = new int[n];
        int[] iKnow = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    knowMe[j]++;
                    iKnow[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            // A celebrity is known by everyone else (n-1 people) and knows no one
            if (knowMe[i] == n - 1 && iKnow[i] == 0) {
                return i;
            }
        }

        return -1;

    }
}
