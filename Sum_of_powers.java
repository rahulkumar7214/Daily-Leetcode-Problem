/*  2787. Ways to Express an Integer as Sum of Powers
    Date : 12-08-2025  Marked---Medium     
*/

class Solution {
    int mod = 1000000007;
    public int solve(int n,int cur, int x, int[][] dp){
        if(n==0){
            return 1;
        }

        if(n<0 || Math.pow(cur, x) >n){
            return 0;
        }
        if(dp[n][cur] != -1){
            return dp[n][cur];
        }

        int t = solve((int)(n-Math.pow(cur, x)), cur+1, x, dp);
        int nt = solve(n, cur+1, x, dp);
        return dp[n][cur] = (t+nt) % mod;
    }
    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n+1][n+1];   // n and curr change ho rhe hai throughout the recurrsion
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }
        return solve(n, 1, x, dp);

    }
}