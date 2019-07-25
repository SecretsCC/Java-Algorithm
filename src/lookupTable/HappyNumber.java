package lookupTable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
        int res = n;
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(res != 1) {
            res = happer(res);
            if(set.contains(res)) return false;
            set.add(res);
        }
        return true;
    }

    private static int happer(int a) {
        int res = 0;
        while(a > 0) {
            int b = a % 10;
            res += (int) Math.pow(b,2);
            a = a/10;
        }
        return res;
    }

    public static void main(String args[]) {
        int test = 2;
        System.out.println(isHappy(test));
    }
}
