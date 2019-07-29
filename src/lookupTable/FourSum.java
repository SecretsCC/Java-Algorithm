package lookupTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        //-2 -1 0 0 1 2

        for(int i = 0; i < nums.length - 3; ++i) {
            if( i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; ++j) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right) {
                    if(nums[left] + nums[right] + nums[i] + nums[j] == target) {
                        res.add(Arrays.asList(nums[left],nums[right],nums[i],nums[j]));
                    }
                    if(nums[left] + nums[right] + nums[i] + nums[j] < target) {
                        int currentLeft = left;
                        while(left < right && nums[left] == nums[currentLeft]) {
                            left++;
                        }
                    }else {
                        int currentRight = right;
                        while(left < right && nums[right] == nums[currentRight]) {
                            right--;
                        }
                    }
                }

            }
        }
        return res;

    }
}
