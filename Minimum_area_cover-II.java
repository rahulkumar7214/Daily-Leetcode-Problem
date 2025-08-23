/* 3197. Find the Minimum Area to Cover All Ones II
   Date : 23-08-2025  Marked---HARD
*/

class Solution {
    public int[][] rotategrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] mat = new int[m][n];

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         mat[j][n - i - 1] = grid[i][j];
        //     }
        // }

        // above or the below one for rotating

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = grid[n-j-1][i];
            }
        }
        return mat;
    }
    public int minarea(int sr, int er, int sc, int ec, int[][] mat){  // sr=start row, er= end row, sc=start col, ec = end col
        int n = mat.length;
        int m = mat[0].length;

        int minr = n, maxr = -1, minc=m, maxc = -1;
        for(int i=sr; i<er; i++){
            for(int j = sc; j<ec; j++){
                if(mat[i][j] == 1){
                    minr = Math.min(minr, i);
                    maxr = Math.max(maxr, i);
                    minc = Math.min(minc, j);
                    maxc = Math.max(maxc, j);
                }
                
            }
        }

        if(maxr == -1){
            return 0;
        }
        return ((maxr-minr+1)*(maxc-minc+1));
    }
    public int helper(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int res = Integer.MAX_VALUE;


        //case 1: top + bottomLeft + bottomRight
        for(int rs = 1; rs<n; rs++){        // rs = row split; 
            for(int cs=1; cs<m; cs++){         // cs = column split

                int top = minarea(0, rs, 0, m, grid);
                int botmleft = minarea(rs, n, 0, cs, grid);
                int botmright = minarea(rs, n, cs, m, grid);

                res = Math.min(res, (top+botmleft+botmright));
            }
        }

        // Case 2: topLeft + topRight + bottom
        for (int rs = 1; rs < n; rs++) {
            for (int cs = 1; cs < m; cs++) {
                int topleft = minarea(0, rs, 0, cs, grid);
                int topright = minarea(0, rs, cs, m, grid);
                int botm = minarea(rs, n, 0, m, grid);

                res = Math.min(res, (topleft + topright + botm));
            }
        }

        // Case 3: top + middle + bottom
        for(int rs1 =1; rs1<n; rs1++){
            for(int rs2 = rs1+1; rs2<n; rs2++){

                int top = minarea(0, rs1, 0, m, grid);
                int mid = minarea(rs1, rs2, 0, m, grid);
                int botm = minarea(rs2, n, 0, m, grid);

                res= Math.min(res, (top+mid+botm));
            }
        }

        return res;
    }
    public int minimumSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = helper(grid);   // this include case1, 2, and case3

        int[][] rotated = rotategrid(grid);  // then rotatethe grid to perform case 4, 5, and case 6 int the same manner

        ans = Math.min(ans, helper(rotated));
        return ans;
    }
}