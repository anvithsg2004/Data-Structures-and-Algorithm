package DSA.Binary_Search;

//This comes under Binary Search on the answers
//Like between the min and max.
//Setting the low as the min and the high as the max.

public class _15_Koko_Eating_Bananas {

    //This method calculates how time it takes to eats those bananas.
    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH = (int) (totalH + Math.ceil((double) (v[i]) / (double) (hourly)));
        }
        return totalH;
    }

    public int finMax(int[] piles) {
        int maxi = Integer.MIN_VALUE;
        int n = piles.length;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, piles[i]);
        }

        return maxi;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        //Find the maximum number in the piles[].
        int high = finMax(piles);

        while (low <= high) {
            int mid = (low + high) / 2;
            int totalHours = calculateTotalHours(piles, mid);

            //If the time taken to eat the bananas is less than the maximum time given then check for the lesser numbers.
            //So go back.
            //Try some still lesser values.
            if (totalHours <= h) {
                high = mid - 1;
            } else {
                //Try some greater value so that it can finish eating those bananas quickly.
                low = mid + 1;
            }
        }

        //Point to remember :-
        //In Binary Search, at last always the low and high will be always in the opposite polarity.
        //Means low goes to high.
        //Next high goes to low.
        //So for the answer return low.


        //Return the low.
        return low;
    }

    public static void main(String[] args) {

    }
}
