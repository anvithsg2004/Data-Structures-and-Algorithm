package DSA.Stack_and_Queue;

import java.util.Stack;

public class _9_Asteroid_Collisions {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            // If the asteroid is moving right or there are no collisions, push it to the stack
            if (asteroid >= 0) {
                stack.push(asteroid);
            } else {
                // Handle collision
                while (!stack.isEmpty() && stack.peek() >= 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();  // Pop the top asteroid if it is smaller
                }

                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) {
                    stack.pop();  // Both asteroids destroy each other
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);  // Add the current asteroid if no collision
                }
            }
        }

        // Convert the stack to the result array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;

    }
}
