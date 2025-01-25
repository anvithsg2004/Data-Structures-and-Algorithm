package DSA.Practice.Arrays.Easy;

public class _7_Remove_One_Element_to_Make_the_Array_Strictly_Increasing {


    //See Video


    public boolean canBeIncreasing(int[] nums) {

        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                count++;
                // If there's more than one violation, return false
                if (count > 1) {
                    return false;
                }
                // Check if removing nums[i-1] or nums[i] can fix the issue
                if (i > 1 && nums[i] <= nums[i - 2] && i < nums.length - 1 && nums[i + 1] <= nums[i - 1]) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {

    }
}
