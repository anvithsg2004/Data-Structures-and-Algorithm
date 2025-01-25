package DSA.Practice.Binary_Search.Easy;

public class _14_Fair_Candy_Swap {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sum1 = 0;

        for (int i = 0; i < aliceSizes.length; i++) {

            sum1 = sum1 + aliceSizes[i];

        }

        int sum2 = 0;

        for (int i = 0; i < bobSizes.length; i++) {

            sum2 = sum2 + bobSizes[i];

        }

        int delta = (sum1 - sum2) / 2;

        if (delta == 0) {

        }

        int i = 0;
        int j = 0;

        int num1 = aliceSizes.length;
        int num2 = bobSizes.length;

        while (num1 > i && num2 > j) {

            int differ = (aliceSizes[i] - bobSizes[j]) / 2;

            if (differ == delta) {

                return new int[]{aliceSizes[i], bobSizes[j]};

            } else if (differ == 0) {
                i++;
                j++;
            } else if (differ > 0) {
                j++;
            }

        }

        return new int[]{-1, -1};

    }

    public static void main(String[] args) {

    }
}
