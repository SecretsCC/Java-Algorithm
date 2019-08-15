package DP;

public class ClimbingStairs {
    int memo[];
    public int backtracking(int i, int n) {
        if(i > n) {
            return 0;
        }
        if(i == n)  return 1;
        if(memo[i] > 0) {
            return memo[i];
        }

        memo[i] =  backtracking(i + 1, n) + backtracking(i + 2,n);
        return memo[i];
    }

    public int climbStairs(int n) {
        memo = new int[n + 1];

        return backtracking(0,n);
    }
}
