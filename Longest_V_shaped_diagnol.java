/* 3459. Length of Longest V-Shaped Diagonal Segment
   Date : 27-08-2025  Marked---HARD
*/

class Solution {
    int[][] dir = {{1,1}, {1,-1}, {-1,-1}, {-1, 1}};
    int n;
    int m;

    public int solve(int i, int j, int d, boolean canturn, int[][] mat, int val){
        int i_ = i+dir[d][0];
        int j_ = j+dir[d][1];

        if((i_>=n || i_<0 || j_>=m|| j_<0) || mat[i_][j_] != val){
            return 0;
        }

        int len =0;
        int keep = 1+solve(i_, j_, d, canturn, mat, (val==2?0:2));
        len = Math.max(len, keep);

        if(canturn== true){
            len = Math.max(len, (1+solve(i_, j_, (d+1)%4, false, mat, (val==2?0:2))) );
        }

        return len;

    }
    public int lenOfVDiagonal(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int res = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){

                    for(int d=0; d<=3; d++){
                        res = Math.max(res, 1+solve(i,j,d, true, grid, 2));
                    }
                }
            }
        }

        return res;
    }
}