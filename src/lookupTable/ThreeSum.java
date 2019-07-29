package lookupTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; ++i) {
            if(i == 0 || nums[i] > nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;
                int sum = 0 - nums[i];
                while(left < right) {
                    if(nums[left] + nums[right] == sum) {
                        res.add(Arrays.asList(nums[left],nums[right],nums[i]));
                    }
                    if (nums[left] + nums[right] < sum) {
                        int currentLeft = left;
                        while(nums[left] == nums[currentLeft] && left < right) {
                            left++;
                        }
                    }else{
                        int currentRight = right;
                        while(nums[right] == nums[currentRight] && left < right) {
                            right--;
                        }
                    }
                }
            }

        }

        return res;
    }

    public static void main(String args[]) {
        int[] test = {-1,0,1,2,-1,-4};
        System.out.print(threeSum(test).toString());
    }
}
