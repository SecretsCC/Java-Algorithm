package lookupTable;

import Stack.ArrayStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < C.length; ++i) {
            for(int j = 0; j < D.length; ++j) {
                int count = map.getOrDefault(C[i] + D[j],0);
                map.put(C[i] + D[j],count + 1);
            }
        }

        int res = 0;
        for(int i = 0; i < A.length; ++i) {
            for(int j = 0; j < B.length; ++j) {
                if(map.containsKey(0 - A[i] - B[j])) {
                    res += map.get(0 - A[i] - B[j]);
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
    }
}
