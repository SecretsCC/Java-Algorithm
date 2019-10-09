package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;

        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] newInterval = intervals[0];
        list.add(newInterval);
        for(int i = 1; i < intervals.length; ++i) {
            if(intervals[i][0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }else{
                newInterval = intervals[i];
                list.add(newInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
