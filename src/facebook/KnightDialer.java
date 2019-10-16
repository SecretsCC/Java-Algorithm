package facebook;

import java.util.Arrays;

public class KnightDialer {
    public static int knightDialer(int N) {
        if (N==1) return 10;
        long[] cur= new long[10];
        Arrays.fill(cur, 1);
        cur[5]=0;
        long res=0, M=(int)1e9+7;;
        while (N-->1){
            long[] next= Arrays.copyOf(cur, 10);
            next[0]=(cur[4]+cur[6])%M;
            next[1]=(cur[6]+cur[8])%M;
            next[2]=(cur[7]+cur[9])%M;
            next[3]=(cur[4]+cur[8])%M;
            next[4]=(cur[3]+cur[9]+cur[0])%M;
            next[6]=(cur[1]+cur[7]+cur[0])%M;
            next[7]=(cur[2]+cur[6])%M;
            next[8]=(cur[1]+cur[3])%M;
            next[9]=(cur[2]+cur[4])%M;
            cur=next;
        }
        for (long n: cur) res=(res+n)%M;
        return (int)res;
    }

    public static void main(String args[]) {
        int res = knightDialer(2);
    }
}
