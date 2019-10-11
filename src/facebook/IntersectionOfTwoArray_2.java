package facebook;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArray_2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l1 = 0;
        int l2 = 0    ;
        ArrayList<Integer> r = new ArrayList<>();
        while(l1 < nums1.length && l2 < nums2.length) {
            if(nums1[l1] == nums2[l2]){
                r.add(nums1[l1]);
                l1+=1;
                l2 +=1;
            } else if(nums1[l1] > nums2[l2]) {
                l2+=1;
            } else if(nums1[l1] < nums2[l2]) {
                l1+=1;
            }
        }

        int[] res = new int[r.size()];
        for (int i =0; i < r.size(); i++) {
            res[i] = r.get(i);
        }

        return res;
    }
}
