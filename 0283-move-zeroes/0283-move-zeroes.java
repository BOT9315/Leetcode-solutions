class Solution {
    public void moveZeroes(int[] nums) {

        int j = 0;

        // Put all non-zero elements at the front
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[j] = nums[i];    //// 0=0 ,0+1,0+2...
                j++;
            }
        }

        // Put zeroes at the remaining positions
        while (j < nums.length) {      //0<1,2,3...
            nums[j] = 0;               //0=0...
            j++;
        }
    }
}