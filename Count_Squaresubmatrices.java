/* 1504. Count Submatrices With All Ones
    Date : 21-08-2025  Marked---Medium
*/
class Solution {
    public int findcount(int[] col){
        int ans =0;
        int conse = 0;
        for(int val : col){
            if(val == 0){
                conse = 0;
            }else{
                conse++;
            }

            ans += conse;
        }

        return ans;
    }
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int res =0;
        for(int sr=0; sr<n; sr++){// sr = starting row

            int[] col = new int[m];  // this is the col which will store the val of each col from top to down 
            Arrays.fill(col, 1);

            for(int er = sr; er<n; er++){  // er = endrow (through which col will store the val of 2d matrix i.e more tha single row)
                 
                for(int i=0; i<m; i++){
                    col[i] = col[i]&mat[er][i];
                }

                res += findcount(col);
            }
        }

        return res;
    }
}