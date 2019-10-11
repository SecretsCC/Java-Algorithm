package facebook;

public class TrappingRainWatter {
    public int trap(int[] height) {
        if(null == height || height.length <2){
            return 0;
        }
        int len = height.length;
        int left = 0, right = len-1;
        int maxLeft = height[0], maxRight = height[len-1];
        int res = 0;
        while(left <= right){
            maxLeft = Math.max(height[left], maxLeft);
            maxRight = Math.max(height[right], maxRight);
            if(maxLeft < maxRight){
                res += maxLeft - height[left];
                left++;
            }else {
                res += maxRight - height[right];
                right--;
            }
        }
        return res;
    }
}
