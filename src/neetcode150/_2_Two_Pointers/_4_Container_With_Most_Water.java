package neetcode150._2_Two_Pointers;

public class _4_Container_With_Most_Water {
    public int maxArea(int[] height) {

        int n = height.length;

        int maxWater = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currentMaxWater = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {

                if (i != j) {

                    int leftWaterPole = height[i];
                    int rightWaterPole = height[j];

                    int waterHeight = 0;

                    if (leftWaterPole < rightWaterPole) {

                        waterHeight = leftWaterPole * (j - i);

                    } else if (leftWaterPole > rightWaterPole) {

                        waterHeight = rightWaterPole * (j - i);

                    } else {

                        waterHeight = leftWaterPole * (j - i);

                    }

                    currentMaxWater = Math.max(currentMaxWater, waterHeight);

                }

            }
            maxWater = Math.max(maxWater, currentMaxWater);
        }

        return maxWater;

    }

    public int maxArea1(int[] height) {

        int n = height.length;

        int maxWater = 0;

        int left = 0;
        int right = n - 1;

        while (left < right) {

            int h = Math.min(height[left], height[right]);
            int width = right - left;

            int area = h * width;
            maxWater = Math.max(maxWater, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return maxWater;

    }
}
