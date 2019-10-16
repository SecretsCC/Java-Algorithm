package facebook;

public class FirstAndLastPositionOfElement {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums,target);
        res[1] = findLast(nums,target);
        return res;

    }

    private int findFirst(int[] nums, int target) {
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right ) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            if(nums[mid] == target) res = mid;
        }
        return res;
    }

    private int findLast(int[] nums, int target) {
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right ) {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            if(nums[mid] == target) res = mid;
        }
        return res;
    }
}
