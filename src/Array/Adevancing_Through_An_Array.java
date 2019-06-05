package Array;

import java.util.ArrayList;
import java.util.List;

public class Adevancing_Through_An_Array {
    /**
     * @requirement:
     * a player has to try to advance through a sequence of positions.
     * Each position has a nonnegative integer associated with it.
     * representing the maximum you can advance from that position in one move
     * @param maxAdvanceSteps
     * @return
     */

    public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
        int furthestReachSoFar = 0;
        int lastIndex = maxAdvanceSteps.size() - 1;

        for(int i = 0; i < lastIndex && furthestReachSoFar < lastIndex; ++i) {
            furthestReachSoFar = Math.max(furthestReachSoFar,maxAdvanceSteps.get(i) + i);
        }

        return furthestReachSoFar >= lastIndex;
    }

    public static void main(String args[]) {
        List<Integer> test = new ArrayList<>();
        test.add(3);
        test.add(3);
        test.add(1);
        test.add(0);
        test.add(2);
        test.add(0);
        test.add(1);
        System.out.println(canReachEnd(test));

    }
}
