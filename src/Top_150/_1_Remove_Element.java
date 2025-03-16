package Top_150;

//Input: nums = [3,2,2,3], val = 3
//Output: 2, nums = [2,2,_,_]

public class _1_Remove_Element {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
