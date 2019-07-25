package Array;

public class MinimumSizeSubarraySum {
    //bruth forth
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int tmp = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; ++i) {
            tmp = nums[i];
            if(tmp >= s) return 1;
            for(int j = i + 1; j < nums.length; ++j) {
                tmp += nums[j];
                if(tmp >= s) {
                    res = Math.min(res,j - i + 1);
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int minSubArrayLen2(int s, int[] nums) {

        int left = 0;
        int right = -1;

        int sum = 0;
        int res = nums.length + 1;

        while(left < nums.length) {
            if(right + 1 < nums.length && sum < s) {
                sum += nums[++right];
            }else{
                sum -= nums[left++];
            }

            if(sum >= s) {
                res = Math.min(res,right - left + 1);
            }
        }

        if(res == nums.length + 1)
            return 0;

        return res;



    }

}
