package DSA.Recursion.Kunal_Kushwaha.Introduction;

public class _11_Number_of_Steps_to_Reduce_a_Number_to_Zero {

    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }

        return helper(num);
    }

    public int helper(int num) {
        if (num == 0) {
            return -1;
        }

        return (num % 2 == 0 ? 1 : 2) + helper(num / 2);
    }

    public static void main(String[] args) {

    }
}
