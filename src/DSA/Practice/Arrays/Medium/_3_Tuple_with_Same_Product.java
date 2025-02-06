package DSA.Practice.Arrays.Medium;

import java.util.ArrayList;
import java.util.HashMap;

class Position {
    int i;
    int j;

    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "(" + i + ", " + j + ")";
    }
}

public class _3_Tuple_with_Same_Product {

    //My Approach
    public static int tupleSameProduct(int[] nums) {

        //Combination of this [a, b, c, d]
        //                    [0, 1, 2, 3]
        //1) [a, c] [b, d]
        //2) [a, d] [b, c]

        int n = nums.length;

        ArrayList<Position> positionArrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    positionArrayList.add(new Position(nums[i], nums[j]));
                }
            }
        }

        System.out.println(positionArrayList.toString());

        int count = 0;

        int arrayListLength = positionArrayList.size();

        for (int i = 0; i < arrayListLength; i++) {
            Position position = positionArrayList.get(i);
            int firstNum = position.i;
            int secondNum = position.j;

            for (int j = 0; j < arrayListLength; j++) {
                if (i != j) {
                    Position position1 = positionArrayList.get(j);
                    int posFirstNum = position1.i;
                    int posSecondNum = position1.j;

                    if (firstNum != posFirstNum && firstNum != posSecondNum && secondNum != posFirstNum && secondNum != posSecondNum) {

                        if (firstNum * secondNum == posFirstNum * posSecondNum) {
                            count++;
                            System.out.println("{" + firstNum + " " + secondNum + " " + posFirstNum + " " + posSecondNum + "}");
                        }
                    }
                }
            }
        }

        return count;

    }

    //My Approach
    public static int tupleSameProduct2(int[] nums) {
        HashMap<Integer, Integer> productCount = new HashMap<>();
        int n = nums.length;

        // Store all products in HashMap
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {  // Avoid duplicate pairs by ensuring i < j
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        int count = 0;

        // Calculate valid tuples
        for (int freq : productCount.values()) {
            if (freq > 1) {
                count += (freq * (freq - 1) / 2) * 8;  // Each pair contributes to 8 valid permutations
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 6};
        tupleSameProduct(arr);
    }
}
