package Array;

import java.util.Arrays;

public class move_zero {
    /**
     * write a function to move all 0 to the end of
     * array while maintaining the relative order of the non-zero elements
     *
     * @param nums
     */

    //double pointer
    //move all non-zero element to the left

    public static void moveZeros(int[] nums) {
        int nonZero = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != 0) {
                nums[nonZero] = nums[i];
                nonZero++;
            }
        }
        while(nonZero < nums.length) {
            nums[nonZero++] = 0;
        }
    }

    public static void main(String args[]) {
        int[] arr = {1,0,2,0,3,5,0,0,6,7,8};
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));

    }
}
