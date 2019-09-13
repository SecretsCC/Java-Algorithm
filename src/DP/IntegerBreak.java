package DP;

public class IntegerBreak {
    int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        return breakInteger(n);
    }

    public int breakInteger(int n) {
        if(n == 1) return  1;
        if(memo[n] != 0) return memo[n];
        int res = -1;
        for(int i = 1; i <= n - 1; ++i) {
            res = Math.max(res, Math.max(i * (n - i), i * breakInteger(n - i)));
        }
        memo[n] =  res;
        return res;
    }
}
