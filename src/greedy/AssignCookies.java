package greedy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length - 1;
        int m = s.length - 1;
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        while(n >= 0 && m >= 0) {
            if(s[m] >= g[n]) {
                res++;
                m--;
                n--;
            }else {
                n--;
            }
        }
        return res;
    }
}
