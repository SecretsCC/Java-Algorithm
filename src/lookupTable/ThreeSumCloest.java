package lookupTable;

import java.util.Arrays;

public class ThreeSumCloest {
    public static int threeSumClosest(int[] nums, int target) {
        int compare = Integer.MAX_VALUE;
        int res = 0;

        for(int i = 0; i < nums.length - 2; ++i) {
            for(int j = i + 1; j < nums.length - 1; ++j) {
                for(int k = j + 1; k < nums.length; ++k ) {
                    int tmp = Math.abs(target - nums[i] - nums[j] - nums[k]);
                    if(tmp < compare) {
                        compare = tmp;
                        res = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return res;
    }

    public int threeSumClosest2(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] test = {-1,2,1,-4};
        System.out.print(threeSumClosest(test,1));
    }
}
