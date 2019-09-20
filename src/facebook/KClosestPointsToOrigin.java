package facebook;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] KClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> ((a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])));
        int[][] res = new int[k][2];
        for(int[] arr : points) {
            pq.add(arr);
        }

        int index = 0;
        while(index < k) {
            res[index++] = pq.poll();
        }
        return res;
    }
}
