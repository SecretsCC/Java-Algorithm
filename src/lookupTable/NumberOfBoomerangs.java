package lookupTable;

import java.util.HashMap;

public class NumberOfBoomerangs {
    //时间复杂度O(n^2)
    //空间复杂度O(n)
    public static int numberOfBoomerangs(int[][] points) {
        int res = 0;

        for(int i = 0; i < points.length;  ++i) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; ++j) {
                if(i != j) {
                    int dis = calculateDis(points[i],points[j]);
                    int num = map.getOrDefault(dis,0) + 1;
                    map.put(dis,num);
                }
            }
            for(int dis : map.keySet()) {
                int count = map.get(dis);
                if(count >=2 ) {
                    res += count * (count - 1);
                }
            }
        }


        return res;
    }

    private static int calculateDis(int[] a, int[] b) {
        return ((a[0] - b[0]) * (a[0] - b[0]) +  (a[1] - b[1]) * (a[1] - b[1]));
    }

}
