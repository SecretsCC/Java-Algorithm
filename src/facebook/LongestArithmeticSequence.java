package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {
        List<Map<Integer,Integer>> table = new ArrayList<>();
        table.add(new HashMap<>());

        int max = 0;
        for(int i = 1; i < A.length; ++i) {
            Map<Integer,Integer> cur = new HashMap<>();
            for(int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                Map<Integer,Integer> mapj = table.get(j);
                int curmax = mapj.getOrDefault(diff,1) + 1;
                cur.put(diff,curmax);
                max = Math.max(max,curmax);
            }
            table.add(cur);
        }
        return max;
    }
}
