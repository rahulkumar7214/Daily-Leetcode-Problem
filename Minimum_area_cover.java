/* 1277. Count Square Submatrices with All Ones
 Date : 22-08-2025  Marked---Medium
*/

class Solution {
    public int minimumArea(int[][] grid) {
        // 
        int n = grid.length;
        int m = grid[0].length;

        int i1= n;
        int i2 = -1;
        int j1 = m;
        int j2 = -1;

        for(int i=0; i<n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j] != 0){
                    
                    i1 = Math.min(i1, i);
                    i2= Math.max(i2, i);
                    j1 = Math.min(j1, j);
                    j2 = Math.max(j2, j);
                }
            }
        }
        
        int l = (j2-j1)+1;
        int b = (i2-i1)+1;
        return (l*b);
    }
}


// Constraints:
// 1 <= grid.length, grid[i].length <= 1000
// grid[i][j] is either 0 or 1.
// The input is generated such that there is at least one 1 in grid.
