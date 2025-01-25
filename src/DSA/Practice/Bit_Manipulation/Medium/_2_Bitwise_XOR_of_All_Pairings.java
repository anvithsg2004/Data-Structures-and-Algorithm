package DSA.Practice.Bit_Manipulation.Medium;

public class _2_Bitwise_XOR_of_All_Pairings {

    public int xorAllNums3(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int xor1 = 0; // XOR of all elements in nums1
        int xor2 = 0; // XOR of all elements in nums2

        // Calculate XOR of all elements in nums1
        for (int num : nums1) {
            xor1 ^= num;
        }

        // Calculate XOR of all elements in nums2
        for (int num : nums2) {
            xor2 ^= num;
        }

        // The Final result depends on the parity of m and n
        int sum = 0;
        if (m % 2 == 1) {
            sum ^= xor1; // Include XOR of nums1 if m is odd
        }
        if (n % 2 == 1) {
            sum ^= xor2; // Include XOR of nums2 if n is odd
        }

        return sum;
    }

    public int xorAllNums2(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                sum = sum ^ nums1[i] ^ nums2[j];

            }
        }

        return sum;

    }

    public int xorAllNums(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int[] result = new int[n * m];

        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                result[index] = nums1[i] ^ nums2[j];
                index++;

            }
        }

        int sum = 0;

        for (int i = 0; i < n * m; i++) {
            sum = sum ^ result[i];
        }

        return sum;

    }

}
