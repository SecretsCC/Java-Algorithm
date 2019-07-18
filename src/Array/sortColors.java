package Array;

import java.util.Arrays;

public class sortColors {
    //quick sort
    public static void sort(int[] nums) {
        int zero = -1;  //nums[0,zero] == 0
        int two = nums.length; //nums[two,nums.length - 1] = 2

        for(int i = 0; i < two; ) {
            if(nums[i] == 1) {
                i++;
            }else if (nums[i] == 2) {
                two--;
                swap(nums,i,two);
            }else {
                if (nums[i] == 0) {
                    zero++;
                    swap(nums,i,zero);
                    i++;
                }
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String args[]) {
        int[] nums = {0,1,2,2,1,0,0,2,1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
