package facebook;

import java.util.HashMap;
import java.util.Map;

public class ContinusSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        if(nums == null || nums.length < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i < nums.length; ++i ) {
            sum += nums[i];
            if( k != 0)
                sum = sum % k;
            if(map.containsKey(sum)) {
                if(i - map.get(sum) > 1)
                    return true;
            }else
                map.put(sum,i);
        }
        return false;
    }
}
