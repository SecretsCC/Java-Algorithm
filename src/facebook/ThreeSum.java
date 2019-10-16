package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; ++i) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int target = nums[i];
            twoSum(nums,target,i + 1);

        }
        return res;
    }

    private void twoSum(int[] num,int target, int start) {
        int l = start, r = num.length - 1;
        while (l < r) {
            if (num[l] + num[r] + target == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(target);
                list.add(num[l]);
                list.add(num[r]);
                res.add(list); //放入结果集中
                while (l < r && num[l] == num[l+1]) l++;
                while (l < r && num[r] == num[r-1]) r--;
                l++;
                r--;
            } else if (num[l] + num[r] + target < 0) {
                l++;
            } else {
                r--;
            }
        }

    }
}
