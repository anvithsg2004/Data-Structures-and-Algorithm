package DSA.Greedy_Algorithms;

public class _4_Lemonade_Change {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;

        int n = bills.length;

        for (int i = 0; i < n; i++) {

            if (bills[i] == 5) {
                five = five + 1;
            } else if (bills[i] == 10) {
                if (five >= 1) {
                    five = five - 1;
                    ten = ten + 1;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if (ten >= 1 && five >= 1) {
                    ten = ten - 1;
                    five = five - 1;
                } else if (five >= 3) {
                    five = five - 3;
                } else {
                    return false;
                }
            }

        }

        return true;

    }
}
