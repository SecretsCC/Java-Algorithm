package facebook;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) return false;
        sum /= 2;

        return helper(nums,0,sum);
    }

    private boolean helper(int[] nums, int index, int target) {
        if(target == 0) return true;
        if(target < 0 || index == nums.length ) return false;

        if(helper(nums,index + 1, target - nums[index])) return true;

        int j = index + 1;
        while(j < nums.length && nums[index] == nums[j]){
            j++;
        }
        return helper(nums,j,target);

    }
}
