/* 3363. Find the Maximum Number of Fruits Collected
    Date : 07-08-2025  Marked---Hard
*/

class Solution {
    int n;
    public int solvefor3rd(int i, int j, int[][] mat, int[][] dp){
        if(i<0||j<0||j>=n||i>=n){
            return 0;
        }
        if(i==n-1 && j==n-1){  //check whether they reach target  room 
            return 0;
        }
        if(i==j || i<j){  // check for whether they have cross or on the diagnol
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int top= mat[i][j] + solvefor3rd(i-1, j+1, mat, dp);
        int midd= mat[i][j] + solvefor3rd(i, j+1, mat, dp);
        int down= mat[i][j] + solvefor3rd(i+1, j+1, mat, dp);

        return dp[i][j] =  Math.max(midd, Math.max(top,down));
    }
    public int solvefor2nd(int i, int j, int[][] mat, int[][] dp){
        if(i<0||j<0||j>=n||i>=n){
            return 0;
        }
        if(i==n-1 && j==n-1){  // check whether they reach target  room 
            return 0;
        }
        if(i==j || i>j){  // check for whether they have cross or on the diagnol
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int left= mat[i][j] + solvefor2nd(i+1, j-1, mat, dp);
        int midd= mat[i][j] + solvefor2nd(i+1, j, mat, dp);
        int right= mat[i][j] + solvefor2nd(i+1, j+1, mat, dp);

        return dp[i][j] = Math.max(midd, Math.max(left,right));

    }
    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;
        // return 7;
        int[][] dp = new int[n][n];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }
        int sum =0;
        for(int i=0; i<n; i++){
            sum += fruits[i][i];
            dp[i][i] = 0;
        }
        int a= solvefor2nd(0, n-1, fruits, dp);
        int b = solvefor3rd(n-1, 0, fruits, dp);
        return sum+a+b;
    }
}