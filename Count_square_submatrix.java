/* 1277. Count Square Submatrices with All Ones
 Date : 27-08-2025  Marked---Medium
*/
//-------------------------------------------->>> 1st way through Memoization---------------------<<
class Solution {
    int n;
    int m;
    public int solve(int i, int j, int[][] mat, int[][] dp){
        //base case
        if(i>=n || j>=m){
            return 0;
        }

        if(mat[i][j] == 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ri = solve(i, j+1, mat, dp);
        int down = solve(i+1, j, mat, dp);
        int diag = solve(i+1, j+1, mat, dp);

        return dp[i][j] = 1+Math.min(ri, Math.min(diag, down));
    }
    public int countSquares(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;

        //way 1
        int res=0;
        int[][] dp = new int[n][m];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==1){
                    res += solve(i, j, matrix, dp);
                }
            }
        }
        return res;
    }
}

//=-------------------------------->>2nd way through tabulation----------------------->
class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int ans =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==1 && i>0 && j>0){
                    matrix[i][j] = 1+ Math.min(
                        matrix[i-1][j-1], 
                        Math.min(matrix[i-1][j], matrix[i][j-1]));
                }
                ans += matrix[i][j];
            }
        }

        return ans;
    }
}