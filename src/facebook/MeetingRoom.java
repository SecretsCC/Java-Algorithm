package facebook;

import java.util.Arrays;

public class MeetingRoom {
    public boolean canAttendMeeting(int[][] intervals) {
        if(intervals == null) return false;

        Arrays.sort(intervals,(a,b) -> (a[0] - b[0]));

        for(int i = 1; i < intervals.length; ++i){
            if(intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }
}
