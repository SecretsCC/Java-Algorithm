package lookupTable;

import Stack.ArrayStack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();

        for(int i = 0; i < nums1.length; ++i) {
            set1.add(nums1[i]);
        }

        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i < nums2.length; ++i) {
            if(set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }

        int[] res = new int[set2.size()];
        int k = 0;
        for(Integer c : set2) {
            res[k]  = c;
        }

        return res;
    }

    public static void  main(String args[]) {
        int[] a = {1,2,2,1};
        int[] b = {2,2};
        int[] res = intersection(a,b);
        System.out.println(Arrays.toString(res));
    }
}
